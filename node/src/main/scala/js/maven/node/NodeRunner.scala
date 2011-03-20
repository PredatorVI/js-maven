package js.maven.node


/**
 * 
 * 
 * @author btilford
 * 
 * <em>Created</em> 3/19/11 8:54 PM
 * @since 1.0
 */

object NodeRunner {
  def run(file:String)(handler:Process => Any) {
    var p = new ProcessBuilder("node",file).start
    return handler(p)
  }
}