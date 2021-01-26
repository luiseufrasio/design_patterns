package behavioral.template_method;
public class Twitter extends SocialNetwork {

    public Twitter(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    
    @Override
    public boolean logIn(String userName, String password) {
        System.out.println("\nChecking user's parameters");
        System.out.println("Name: " + this.userName);
        System.out.print("Password: ");
        
        password.chars().mapToObj(c -> (char)'*').forEach(System.out::print);

        simulateNetworkLatency();
        System.out.println("\n\nLogIn success on Twitter");

        return true;
    }
    
    @Override
    public void logOut() {
        
        System.out.println("User: '" + userName + "' was logged out from Twitter");
    }
    
    @Override
    public boolean sendData(byte[] data) {
        final boolean messagePosted = (data.length <= 144);
        
        if (messagePosted) {
        
            System.out.println("Message: '" + new String(data) + "' was posted on Twitter");
            return true;
        } else {
        
            System.out.println("Sorry, message: '" + new String(data) + "' has more than 144 characteres!");
            return false;
        }
    }
    
    private void simulateNetworkLatency() {
        try {
            
            int i = 0;
            System.out.println();
            
            while (i < 10) {
                System.out.print(".");
                Thread.currentThread();
				Thread.sleep(500);
                i++;
            }
            
        } catch (InterruptedException ex) {
            
            ex.printStackTrace();
        }
    }
}