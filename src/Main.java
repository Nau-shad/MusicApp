import java.util.*;

public class Main {
    public static List<Album> albums = new ArrayList<>();
    public static void main(String[] args) {


         Album album1= new Album("Atif Hits","Aatif Aslam");
         album1.addSongToAlbum("Aadat", 5.7);
         album1.addSongToAlbum("Tu jane na", 6.0);

         Album album2 = new Album("Arijit Hits" , "Arijit Singh");
         album2.addSongToAlbum("Aashiqi", 5.10);
         album2.addSongToAlbum("Jeena Jeena" , 6.3);
         album2.addSongToAlbum("channa mere aaa" , 6.0);







         albums.add(album1); albums.add(album2);

         System.out.println(album1.findSong("Aadat"));// testing for find song

        LinkedList<song> myPlayList = new LinkedList<>();
        album1.addToPlaylistFromAlbum ("Aadat",myPlayList);
        album2.addToPlaylistFromAlbum(1,myPlayList);
        album2.addToPlaylistFromAlbum("Jeena Jeena",myPlayList);
        album1.addToPlaylistFromAlbum(2,myPlayList);


//        song sample = new song("xyz",5);
//        System.out.println(sample);
        play(myPlayList);
    }
    public static void play(LinkedList<song>playList){
        ListIterator<song> itr = playList.listIterator();
        Scanner sc= new Scanner(System.in);
        boolean isForward=false;

        if(playList.size()>0){
            System.out.println("Currently playing ");
            System.out.println(itr.next());
            isForward=true;

        }
       else{
            System.out.println("Playlist is empty");
            return;
        }
        System.out.println("Enter your choice");
         printMenu();
         boolean quit =false;
         while(!quit){
            if( isForward==false){
                //previous se aa rhe h iska matlab h
              itr.next();
              isForward=true; // one step here and next step to next case a step
           }
             int choice =sc.nextInt();
             switch (choice) {
                 case 1:
                     if(itr.hasNext()){
                         System.out.println(itr.next());
                     }
                     else{
                         System.out.println("No more song!!!!");
                         isForward=false;// kyuki age kuch nhi h
                     }
                 break;
                 case 2:
                     if(isForward==true){
                         itr.previous();
                         isForward=false;
                     }
                     if(itr.hasPrevious()){
                         System.out.println(itr.previous());
                     }
                     else{
                         System.out.println("First song of playlist");
                         isForward=true;
                     }
                     break;
                 case 3:
                     if(isForward==true){
                         if(itr.hasPrevious()){
                         System.out.println(itr.previous());
                         isForward=false;
                         }
                         else{
                             System.out.println("Song doest exist");
                         }

                     }
                     else{
                        if( itr.hasNext() ){
                            System.out.println(itr.next());
                            isForward=true;
                        }

                     }
                     break;
                 case 4:
                     printMenu();
                     break;
                 case 5:
                     //hme khud se imp krna h
                     break;
                 case 6:
                     printSongs(playList);
                     break;
                 case 7:
                     quit=true;
                     break;

             }

         }
    }

   public static void printSongs(LinkedList<song>playList){
        for(song s : playList){
            System.out.println(s);

        }
        return;
   }

    public static void printMenu(){

        System.out.println("1. Play next song");
        System.out.println("2. Play previous song");
        System.out.println("3. Repeat song");
        System.out.println("4. show menu again");
        System.out.println("5. Delete the current song"); //itr.remove se implement hoga
        System.out.println("6. print all song ");
        System.out.println("7. Exit");
    }

}