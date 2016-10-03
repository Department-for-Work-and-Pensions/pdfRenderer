package gov.dwp.carers.pdfrenderer.generators.claim;

import gov.dwp.carers.pdfrenderer.controllers.PdfServiceApplication;
import gov.dwp.carers.pdfrenderer.generators.PdfGenerator;
import gov.dwp.carers.pdfrenderer.generators.PdfSpecification;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.inject.Inject;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * Created by peterwhitehead on 06/05/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = PdfServiceApplication.class)
@TestPropertySource(locations="classpath:test.application.properties")
public class PdfFunctionalCasesClaimTest extends PdfSpecification {
    private static final Logger LOGGER = LoggerFactory.getLogger(PdfFunctionalCasesClaimTest.class);

    @Value("${jrxml.folder}")
    private String jrxmlLocation;

    @Inject
    private PdfGenerator pdfGenerator;

    @Test
    public void testClaimFunctionalTest() throws Exception {
        final File allFiles = new File(jrxmlLocation);
        final List<File> list = Arrays.asList(allFiles.listFiles());
        list.parallelStream().filter(f -> f.isDirectory()).forEach(folder -> {
            try {
                for (int i = 1; i <= 15; i++) {
                    LOGGER.info("circsFunctionalTest for version =" + folder.getName() + " test case=" + i);
                    final String pdfFileLocation = "functionalTestCase" + i + "_testGeneratorResultIsSuccess.pdf";
                    final String source = new String(Files.readAllBytes(Paths.get(getClass().getResource("/" + folder.getName() + "/claim/c3_functional" + i + ".xml").toURI())));
                    generatorResultIsSuccess(pdfFileLocation, source, pdfGenerator);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }
}