package jcheng.jersey

import javax.servlet.http._
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import jcheng.demo.model.User
import scala.collection.JavaConversions.seqAsJavaList
import javax.ws.rs.GET

/**
 * Congratulations! You discovered the hidden Scala demo! As you can see, Scala works flawlessly with JAX-RS. 
 */
@Path("/helloFromScala")
class HelloScalaResource {
  
  val MESSAGES = Array("hello", "world", "from", "Scala")

  // Return JSON or XML based on the 'Accept' header, e.g., 'Accept: application/json'.
  @GET
  @Produces(Array(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML))
  def getUser():User = {
    val user = new User()
    user.setMessages(seqAsJavaList(MESSAGES))
    user.setEmail("scala@example.com")
    user.setAlias("Scala")
    return user
  }
  
  /**
   * You should not define separate methods just to provide json and xml output, however, for the convenience of the
   * users of the demo, we allow one to see specific formatting with the urls:
   * 
   * <code>
   * http://localhost:8080/rest/helloFromScala/json
   * http://localhost:8080/rest/helloFromScala/xml
   * </code> 
   */ 
  @Path("json")
  @GET
  @Produces(Array(MediaType.APPLICATION_JSON))
  def forConvenienceOnlyGetUserJson():User = getUser()
  
  @Path("xml")
  @GET
  @Produces(Array(MediaType.APPLICATION_XML))
  def forConvenienceOnlyGetUserXml():User = getUser()
  
  
}
