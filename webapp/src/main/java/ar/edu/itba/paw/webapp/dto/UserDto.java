package ar.edu.itba.paw.webapp.dto;

import ar.edu.itba.paw.models.User;
import ar.edu.itba.paw.webapp.dto.links.UserLinks;

import javax.ws.rs.core.UriInfo;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class UserDto {

    private long id;
    private String username;
    private String firstname;
    private String lastname;
    private UserLinks links;

    public static UserDto fromUser(final UriInfo uriInfo, final User user) {
        final UserDto dto = new UserDto();
        dto.id = user.getId();
        dto.username = user.getUsername();
        dto.firstname = user.getFirstname();
        dto.lastname = user.getLastname();
        dto.links = UserLinks.fromUser(uriInfo, user);
        return dto;
    }

    public long getId() { return id; }
    public String getUsername() { return username; }
    public String getFirstname() { return firstname; }
    public String getLastname() { return lastname; }
    public UserLinks getLinks() { return links; }
}
