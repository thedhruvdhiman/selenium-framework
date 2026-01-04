package infinity.features;

import infinity.Test.Components.Base;
import io.cucumber.java.*;

public class CucumberHooks extends Base {

    @Before
    public void setup() throws Exception {
        beforeMethod();
    }

    @After
    public void end(){
        afterMethod();
    }

}
