# Intellij IDEA Maven classifier bug

This has been reported as [IDEA-155363](https://youtrack.jetbrains.com/issue/IDEA-155363).

This project builds two jars for a module (`test-resource`) - one normal jar that contains the
resources in the `src/main/resources` folder, and one with a custom Maven (`my-classifier`) that
contains files from a foler `src/my-resources`.

* If you run `mvn clean verify` on this project, it passes
* If you run the tests in the `ResourceTest` class directly from Intellij IDEA, it fails

The problem appears to be that IDEA is ignoring the classifier when building its classpath, and
is importing the normal jar instead of the one with the classifier.
