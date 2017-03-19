/**
 * Bean Validation TCK
 *
 * License: Apache License, Version 2.0
 * See the license.txt file in the root directory or <http://www.apache.org/licenses/LICENSE-2.0>.
 */
package org.hibernate.beanvalidation.tck.tests.xmlconfiguration.versioning;

import static org.testng.Assert.assertEquals;

import javax.validation.Configuration;

import org.hibernate.beanvalidation.tck.util.TestUtil;
import org.hibernate.beanvalidation.tck.util.shrinkwrap.WebArchiveBuilder;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.testng.Arquillian;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.test.audit.annotations.SpecAssertion;
import org.jboss.test.audit.annotations.SpecVersion;
import org.testng.annotations.Test;

/**
 * @author Guillaume Smet
 */
@SpecVersion(spec = "beanvalidation", version = "2.0.0")
public class Version20InValidationXmlTest extends Arquillian {

	@Deployment
	public static WebArchive createTestArchive() {
		return new WebArchiveBuilder()
				.withTestClass( Version20InValidationXmlTest.class )
				.withValidationXml( "validation-Version20InValidationXmlTest.xml" )
				.build();
	}

	@Test
	@SpecAssertion(section = "8.2", id = "a")
	public void testValidationXmlVersion20() {
		Configuration<?> config = TestUtil.getConfigurationUnderTest();
		assertEquals(
				config.getBootstrapConfiguration().getClockProviderClassName(),
				"org.hibernate.beanvalidation.tck.tests.xmlconfiguration.versioning.DummyClockProvider",
				"Wrong clock provider class name."
		);
	}
}