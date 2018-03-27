package behavioral.template.method;
public abstract class SocialNetwork {

    protected String userName;
    protected String password;
    
    public SocialNetwork() {}
    
    public final boolean post(String message) {
        
        if (logIn(this.userName, this.password)) {
            boolean result = sendData(message.getBytes());
            logOut();
            
            return result;
        }
        
        return false;
    }
    
    abstract boolean logIn(String userName, String password);
    abstract void logOut();
    abstract boolean sendData(byte[] data);
}