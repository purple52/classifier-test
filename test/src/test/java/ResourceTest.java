import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItem;

import java.util.List;
import java.util.regex.Pattern;

import org.junit.Test;
import org.reflections.Reflections;
import org.reflections.scanners.ResourcesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

public class ResourceTest {

    @Test
    public void shouldFindMyResource() {
        List<String> resources = new Reflections(
                new ConfigurationBuilder()
                        .setUrls(ClasspathHelper.forClassLoader())
                        .setScanners(new ResourcesScanner()))
                .getResources(Pattern.compile(".*\\.txt")).stream()
                .collect(toList());

        resources.forEach(System.out::println);

        assertThat(resources, hasItem("my-resources/my-classifier-resource.txt"));
    }
}
