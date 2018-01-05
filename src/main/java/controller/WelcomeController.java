package controller;

import enttity.AppUser;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.AppUserService;


@RestController
@RequestMapping("/welcome")
public class WelcomeController {
    @Autowired
    AppUserService userDao;
    @RequestMapping(method = RequestMethod.GET)
    public String  printWelcome(ModelMap model) {
        JSONObject jsonObject = new JSONObject();
        userDao.allAppUser().stream().forEach(user -> {
            JSONObject jsonUserInfo = new JSONObject();
            jsonUserInfo.put("id", user.getId());
            jsonUserInfo.put("name", user.getFirst_name());
            jsonUserInfo.put("second name", user.getSecond_name());
            jsonUserInfo.put("email", user.getEmail());
            jsonObject.put("user", jsonUserInfo);
        });
        return jsonObject.toString();
    }
}
