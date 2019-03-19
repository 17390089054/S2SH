package com.qst.giftems.login;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.qst.core.utils.ActionContextUtils;
import com.qst.giftems.user.pojos.User;
/**
 * Session管理类.
 */
public class LoginManager {
    private static final Log LOGGER = LogFactory.getLog(LoginManager.class);
    private static final String LOGIN_FLAG = LoginManager.class.getSimpleName(); 
    // 两个Map存储已登录用户及其对应的HttpSession. 键都是用户ID.
    private static final ConcurrentHashMap<Integer, User> USERS        
            = new ConcurrentHashMap<Integer, User>();
    private static final ConcurrentHashMap<Integer, HttpSession> SESSIONS        
            = new ConcurrentHashMap<Integer, HttpSession>();

    /**
     * 登录.记录用户及其对应的HttpSession
     */
    public static void login(User user) {
        logout(user.getId());
        HttpSession session = currentSession();
        UserSessionBindingListener listener = new UserSessionBindingListener();
        listener.user = user;
        session.setAttribute(LOGIN_FLAG, listener);
    }

    /**
     * 当前会话中的用户退出
     */
    public static void logout() {
        logout(currentSession());
    }
    /**
     * 获取在线用户的数量
     */
    public static int getOnlineNum() {
        return USERS.size();
    }
    /**
     * 判断用户是否在线
     */
    public static boolean isOnline(){
       return (currentUser() != null);
    }
    /**
     * 判断用户是否在线
     */
    public static boolean isOnline(String userName) {
        boolean b = false;
        // 获取在线用户集合
        Collection<User> set = USERS.values();
        for (User admin : set) {
            if (admin.getUserName().equals(userName)) {
                b = true;
                break;
            }
        }
        return b;
    }
    /**
     * 特定ID的用户退出
     */
    public static void logout(Integer userId) {
        logout(SESSIONS.get(userId));
    }

    /**
     * 特定会话的用户退出
     * 
     * @param session
     *            会话
     */
    public static void logout(HttpSession session) {
        if (session == null)
            return;
        session.removeAttribute(LOGIN_FLAG);
        session.invalidate();
    }

    /**
     * 获取当前会话的已登录用户。
     * 
     * JSP中可通过 ${LoginManager.currentUser}获取。
     * 
     * @return 已登录用户
     */
    public static User currentUser() {
        return getLoggedinUser(currentSession());
    }
    /**
     * 获取当前会话的已登录用户。
     * 
     * JSP中可通过 ${LoginManager.currentUser}获取。
     * 
     * @return 已登录用户
     */
    public static Integer getCurrentUserId() {
        return currentUser().getId();
    }
    /**
     * 获取特定会话的已登录用户。
     * 
     * @return 已登录用户
     */
    public static User currentUser(HttpSession session) {
        return getLoggedinUser(session);
    }

    /**
     * 获取所有已登录用户
     * 
     * @return 已登录用户
     */
    public static Collection<User> getLoggedinUsers() {
        return Collections.unmodifiableCollection(USERS.values());
    }

    /**
     * 获取所有已登录用户的ID
     * 
     * @return 已登录用户ID
     */
    public static Set<Integer> getLoggedinUserIds() {
        return Collections.unmodifiableSet(USERS.keySet());
    }

    /**
     * 获取特定ID的已登录用户
     * 
     * @param userId
     *            用户ID
     * @return 已登录用户
     */
    public static User getLoggedinUser(Integer userId) {
        return USERS.get(userId);
    }

    /**
     * 获取特定会话中的已登录用户
     * 
     * @param session
     *            会话
     * @return 已登录用户
     */
    public static User getLoggedinUser(HttpSession session) {
        if (session == null)
            return null;
        UserSessionBindingListener listener 
                = (UserSessionBindingListener) session.getAttribute(LOGIN_FLAG);
        if (listener == null)
            return null;
        return listener.user;
    }

    // 当前会话
    private static HttpSession currentSession() {
        return ActionContextUtils.getRequest().getSession();
    }
    /**
     * HttpSessionBindingLister监听器
     *
     */
    public static class UserSessionBindingListener implements HttpSessionBindingListener {
        /**User对象的引用**/
        User user;
        /**获取当前用户**/
        public User getCurrentUser() {
            return user;
        }
        /**User和Session自动绑定**/
        public void valueBound(HttpSessionBindingEvent e) {
            HttpSession session = e.getSession();
            USERS.put(user.getId(), user);
            SESSIONS.put(user.getId(), session);
            LOGGER.debug("USER " + user.getUserName() + " LOGIN");
        }
        /**User和Session自动解除绑定**/
        public void valueUnbound(HttpSessionBindingEvent e) {
            USERS.remove(user.getId());
            SESSIONS.remove(user.getId());
            LOGGER.debug("USER " + user.getUserName() + " LOGOUT");
        }
    }
}
