package org.example.controler;

import com.atlassian.connect.spring.AtlassianHostUser;
import org.example.repository.SavedValueEntity;
import org.example.service.SavedValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class ConnectSpringBootController {

    @Autowired

    private SavedValueService savedValueService;

    @RequestMapping(value = "/connect-view", method = RequestMethod.GET)

    public String getViewPage(@AuthenticationPrincipal AtlassianHostUser hostUser, Model model) {

        addValueAttributeToModel(hostUser, model);

        return "view";

    }

    @RequestMapping(value = "/connect-edit", method = RequestMethod.GET)

    public String getEditPage(@AuthenticationPrincipal AtlassianHostUser hostUser, Model model) {

        addValueAttributeToModel(hostUser, model);

        return "edit";

    }

    @RequestMapping(value = "/connect-edit", method = RequestMethod.POST)

    public void saveValue(@AuthenticationPrincipal AtlassianHostUser hostUser, @ModelAttribute("text-input") String value) {

        savedValueService.setForClientKey(hostUser.getHost().getClientKey(), value);

    }

    private void addValueAttributeToModel(@AuthenticationPrincipal AtlassianHostUser hostUser, Model model) {

        SavedValueEntity entity = savedValueService.getByClientKey(hostUser.getHost().getClientKey());

        String value = entity != null ? entity.getValue() : "";

        model.addAttribute("value", value);

    }

}