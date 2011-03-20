package js.maven.node.mojos

import org.apache.maven.plugin.testing.AbstractMojoTestCase

/**
 * 
 * 
 * @author btilford
 * 
 * <em>Created</em> 3/19/11 11:12 PM
 * @since 1.0
 */
class NodeRunMojoTests extends AbstractMojoTestCase {


  void testNodeRun() {
    def pomPath = getClass().getResource("/testcase-pom.xml")?.path
    assert pomPath
    def pom = new File(pomPath)
    assert pom.exists()

    def mojo = new NodeRunMojo()
    configureMojo mojo, "node-mojos",pom
//    def mojo = lookupMojo(
//        "js-maven",
//        "node-mojos",
//        "1.0-SNAPSHOT",
//        "run",
//        extractPluginConfiguration("node-mojos",pom)
//    )

//    assert mojo
    mojo.execute()

    assert getClass().getResource("/created-by-nodejs")?.path
  }
}
