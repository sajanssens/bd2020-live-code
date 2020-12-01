package org.example.resources;

import org.example.App;
import org.example.domain.Contact;
import org.example.domain.generified.ContactDaoDB;
import org.example.domain.generified.Dao;
import org.example.domain.Laptop;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import java.net.URL;

import static javax.ws.rs.client.Entity.entity;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Arquillian.class)
public class ContactsResourceIT {

    @ArquillianResource
    private URL deploymentURL;

    private String contactsResource;
    private String contactsUri = "api/contacts";

    @Before
    public void setup() {
        contactsResource = deploymentURL + contactsUri;
    }

    @Deployment
    public static Archive<?> createDeployment() {
        WebArchive archive = ShrinkWrap.create(WebArchive.class, "ContactsResourceIT.war")
                .addClass(App.class) // dont forget!
                .addClass(JsonResource.class)
                .addClass(ContactsResource.class)
                .addClass(Contact.class)
                .addClass(Laptop.class)
                .addClass(Dao.class)
                .addClass(ContactDaoDB.class)
                .addAsWebInfResource("test-beans.xml", "beans.xml")
                .addAsWebInfResource("test-persistence.xml", "classes/META-INF/persistence.xml");
        System.out.println(archive.toString(true));
        return archive;
    }

    @Test
    public void whenContactIsPostedICanGetIt() {
        Client http = ClientBuilder.newClient();
        Contact c = Contact.builder().id("1").firstName("Sammie").surname("Smith").email("sam.smith@music.com").build();

        String postedContact = http
                .target(contactsResource)
                .request().post(entity(c, APPLICATION_JSON), String.class);

        System.out.println(postedContact);

        String allContacts = http
                .target(contactsResource)
                .request().get(String.class);

        System.out.println(allContacts);

        assertThat(allContacts, containsString("\"id\":\"1\""));
        assertThat(allContacts, containsString("\"firstName\":\"Sammie\""));
        assertThat(allContacts, containsString("\"surname\":\"Smith\""));
        assertThat(allContacts, containsString("\"email\":\"sam.smith@music.com\""));
    }
}
