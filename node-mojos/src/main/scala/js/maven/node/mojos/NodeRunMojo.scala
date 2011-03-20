package js.maven.node.mojos

import org.apache.maven.plugin.{MojoExecutionException, AbstractMojo}
import js.maven.node.NodeRunner
import io.Source

/**
 * 
 * 
 * @author btilford
 * 
 * <em>Created</em> 3/19/11 10:57 PM
 * @since 1.0
 */

/**
 * Run node.js
 *
 * @goal run
 *
 */
class NodeRunMojo extends AbstractMojo {

  /**
   * The file to run with node.js
   * @alias file
   * @parameter expression="${project.build.outputDirectory}/server.js"
   * @required
   */
  var file : String = _;

  @throws(classOf[MojoExecutionException])
  override def execute() {
    NodeRunner.run(getClass.getResource("/" + file).getPath) {process:Process =>
      for(line <- Source.fromInputStream(process.getInputStream,"UTF-8").getLines) {
        getLog.info(line)
      }
      return process.waitFor
    }
  }

}