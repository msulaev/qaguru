package guru.qa;

import guru.qa.domain.Root;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class JsonTest {

    @Test
    public void jsonShouldBeParsed() throws IOException {
        ObjectMapper om = new ObjectMapper();
        Root root = om.readValue(new File("src/test/resources/example.json"), Root.class);
        assertThat(root.name).isEqualTo("Cake");
        assertThat(root.batters.batter.get(0).id).isEqualTo("1001");
        assertThat(root.topping.get(0).id).isEqualTo("5001");
    }
}
