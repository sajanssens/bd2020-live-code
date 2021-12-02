package org.example.resources.generified;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.example.domain.User;
import org.example.domain.generified.Dao;
import org.example.domain.generified.UserDao;
import org.example.resources.JsonResource;
import org.example.util.KeyGenerator;

import javax.inject.Inject;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.logging.Logger;

import static java.time.LocalDateTime.now;
import static javax.ws.rs.core.HttpHeaders.AUTHORIZATION;
import static javax.ws.rs.core.Response.Status.UNAUTHORIZED;

@Path("/users")
public class UsersResource extends Resource<User> implements JsonResource {

    @Context
    private UriInfo uriInfo;

    @Inject
    private Logger log;

    @Inject
    private KeyGenerator keyGenerator;

    @Inject
    public void setDao(Dao<User> dao) { this.dao = dao; }

    public UserDao getDao() { return (UserDao) this.dao; }

    @POST @Path("/login2")
    public Response login2(User u) {
        try {
            String login = u.getUsername();
            String password = u.getPassword();

            getDao().findByUsernameAndPassword(login, password);
            String token = issueToken(login);
            u.setToken(token);
            u.setPassword("");

            return Response.ok()
                    .type(MediaType.APPLICATION_JSON_TYPE)
                    .header(AUTHORIZATION, "Bearer " + token)
                    .entity(u)
                    .build();
        } catch (Exception e) {
            return Response.status(UNAUTHORIZED).build();
        }
    }


    @POST
    public User register(User u) {
        getDao().add(u);
        return u;
    }

    @POST @Path("/login")
    public User login(User u) {
        try {
            String username = u.getUsername();
            String password = u.getPassword();

            User user = getDao().findByUsernameAndPassword(username, password);
            String jwt = issueToken(username);
            user.setToken(jwt);
            u.setPassword("");

            return user;
        } catch (Exception e) {
            throw new NotAuthorizedException("User " + u + " is not authorized.");
        }
    }

    private String issueToken(String username) {
        Key password = keyGenerator.generateKey();
        String jwt = Jwts.builder()
                .setSubject(username)
                .setIssuer(uriInfo.getAbsolutePath().toString())
                .setIssuedAt(new Date())
                .setExpiration(toDate(now().plusMinutes(15L)))
                .signWith(SignatureAlgorithm.HS512, password)
                .compact();
        log.info("#### generated token: " + jwt);
        return jwt;
    }

    private Date toDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
}
