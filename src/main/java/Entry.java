import bl.Util;
import enttity.AppUser;
import service.AppUserService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class Entry {
    public static void main (String[] args){
        AppUserService appUserService = new AppUserService();
        appUserService.allAppUser().stream().forEach(i -> {System.out.println(i);});
    }
}