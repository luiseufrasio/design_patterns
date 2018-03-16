public class Facebook extends SocialNetwork {

    public Facebook(String userName, String password) {
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
        System.out.println("\n\nLogIn success on Facebook");

        return true;
    }
    
    @Override
    public void logOut() {
        
        System.out.println("User: '" + userName + "' was logged out from Facebook");
    }
    
    @Override
    public boolean sendData(byte[] data) {
        final boolean messagePosted = true;
        
        if (messagePosted) {
        
            System.out.println("Message: '" + new String(data) + "' was posted on Facebook");
            return true;
        } else {
        
            return false;
        }
    }
    
    private void simulateNetworkLatency() {
        try {
            
            int i = 0;
            System.out.println();
            
            while (i < 10) {
                System.out.print(".");
                Thread.currentThread().sleep(500);
                i++;
            }
            
        } catch (InterruptedException ex) {
            
            ex.printStackTrace();
        }
    }
}