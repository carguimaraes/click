package testeintegracao.webapi.controller;



import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import gma.click.domain.entity.Click;
import gma.click.webapi.dto.ClickDto;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import static org.hamcrest.Matchers.*;


//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = Principal.class)
public class ClickControllerTest {
	
	
    //@Autowired
    //private MockMvc _mockMvc;
    
   // @MockBean
   // private IClickRepository _clickRepository;
    
 //   @Autowired
  //  private WebApplicationContext _webApplicationContext;
 

   // @Before
   // public void setup() throws Exception {
    //    this._mockMvc =MockMvcBuilders.webAppContextSetup(_webApplicationContext).build();
   // }
 

    @Test
    public void x()
    {
    	  Client client = ClientBuilder.newClient();
    	  
    	  WebTarget target = client.target("http://localhost:8080");
    	  
    ///	  ClickDto dto = target.path("/api/v1/clicks/19673").request().get(ClickDto.class);
    	  
    	  try {
    		
    		  Object  r= target.path("/api/v1/clicks/196799").request().get(Object.class);
    	   } catch (Exception e) {
    	 
    		   System.out.println(e.getMessage());
    		    
    	
    	  }
    //	 Response r= target.path("/api/v1/clicks/196799").request().get();
    	 
    	// String[] ss= (String[] )  r.getEntity();
    	 
    	 
    	 
    	 
    	 
    	  //System.out.println(dto.getAccount_id());
    	  
    	  
    }
    
    
    @Ignore
	@Test
	public void exampleTest() throws Exception {
		
    	
	
    Click ck= new Click();
    
    ck.setAd_id("21");
	
	//Mockito.when(_clickRepository.getById("")).thenReturn(ck);
   
		
	//	 _mockMvc.perform(get("/api/v1/clicks/1"))
	//	  .andExpect(status().isOk())
	//	  .andExpect(jsonPath("$.ad_id", is("1967")));

	}

}
