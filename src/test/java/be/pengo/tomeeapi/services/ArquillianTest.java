package be.pengo.tomeeapi.services;

import be.pengo.tomeeapi.RESTConfiguration;
import be.pengo.tomeeapi.entities.Contact;
import be.pengo.tomeeapi.entities.MyEntity;
import be.pengo.tomeeapi.entities.Region;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.net.URL;

@RunWith(Arquillian.class)
public class ArquillianTest {
    

    @Deployment(testable = false)
    public static WebArchive createDeployment() {
        WebArchive webArchive = ShrinkWrap.create(WebArchive.class)
                .addPackages(true, new String[]{"be.pengo.tomeeapi"})
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsWebInfResource("test-persistence.xml", "persistence.xml");
        System.out.println("javaArchive content: " +  webArchive.toString(true));
        return webArchive;
    }

    @ArquillianResource
    private URL webappUrl;

    @Test
    public void helloWorld() {
        System.out.println("webappUrl: " + webappUrl.getPath());
        Assert.assertNotNull(webappUrl);
    }
}
