package testeintegracao.webapi.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.internal.MockitoCore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.hamcrest.Matchers.*;

import gma.click.config.Principal;
import gma.click.domain.entity.Click;
import gma.click.domain.respository.IClickRepository;
import gma.click.webapi.controller.ClickController;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Principal.class)
public class ClickControllerTest {
	
	
    //@Autowired
    private MockMvc _mockMvc;
    
   // @MockBean
   // private IClickRepository _clickRepository;
    
    @Autowired
    private WebApplicationContext _webApplicationContext;
 

    @Before
    public void setup() throws Exception {
        this._mockMvc =MockMvcBuilders.webAppContextSetup(_webApplicationContext).build();

    }
 


	@Test
	public void exampleTest() throws Exception {
		
	
    Click ck= new Click();
    
    ck.setAd_id("21");
	
	//Mockito.when(_clickRepository.getById("")).thenReturn(ck);
   
		
		 _mockMvc.perform(get("/api/v1/clicks/1"))
		  .andExpect(status().isOk())
		  .andExpect(jsonPath("$.ad_id", is("1967")));

	}

}
