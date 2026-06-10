package test;


import rsc.util.CryptoManager;


public class TestMain {
    
    public static void main(String[] args) {

        

        System.out.println(com.shutils.UtilHandler.Instance().cryptoService().getHash("1.1.2"));
   
        
        /*  var login = service.sessionService(new Session().setActionName("SSNBTN_00"))
                .login(new Credentials("paradox", "010203"));

        if (login != null) {
            System.out.println(login.getMessage());
            System.out.println(login.getData().getToken());
        } else {
            System.out.println("null");
        }
        hUQC4cNEeq1yKyYwHGVSYA== 0VeqeVwh2hsF7dWIYPo8zL9SKt1wquW+1hswMrsMiSg=
        System.exit(0);*/
    }
    
}
