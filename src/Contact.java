public class Contact {
    
    private Integer cid;
    private String nom ;
    private String tel1 ;
    private String tel2;
    private String email ;
    private String mention ;
    private byte[] pic ;
    private int uid ;
    
    //Alt + ins 
    // pour générer des constructeurs getters setters
    
    public Contact(){}
    
    
    public  Contact(Integer cid, String nom, String tel1, String tel2, String email, String mention,byte[] pic,int uid) {
        this.cid = cid;
        this.nom = nom ;
        this.tel1 = tel1;
        this.tel2 = tel2;
        this.email = email ;
        this.mention = mention ;
        this.pic = pic ;
        this.uid = uid ;
    }
    
     public int getCid(){
        return cid  ; 
     } 
   
     public void setCid(int cid){
        this.cid = cid ;
     }
    
     public void setnom(String nom){
        this.nom = nom ;
     }
    
     public String getnom(){
        return nom ;
    }
     
     public String gettel1(){
        return tel1  ; 
     } 
   
     public void settel2(String tel1){
        this.tel2 = tel2 ;
     }
     
 
    public String gettel2(){
        return tel2  ; 
     } 
   
     public void settel1(String tel1){
        this.tel2 = tel2 ;
     }
     
     public String getemail(){
        return email  ; 
     } 
   
     public void setemail(String tel1){
        this.email = email ;
     }
     
    public String getmention(){
        return mention  ; 
     } 
   
     public void setmention(String mention){
        this.mention = mention ;
     }
     
     public byte[] getpic(){
        return pic  ; 
     } 
   
     public void setpic( byte[]pic){
        this.pic = pic ;
     }
     
     
     public int getuid(){
        return uid  ; 
     } 
   
     public void setuid(int uid){
        this.cid = uid ;
     }
     
     
     
     }
    
   
    
     
    

