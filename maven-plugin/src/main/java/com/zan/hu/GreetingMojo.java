package com.zan.hu;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;

/**
 * @version 1.0
 * @Author hupeng
 * @Date 2020-05-24 12:19
 * @Description
 **/
@Mojo(name = "sayhi")
public class GreetingMojo extends AbstractMojo {
    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        getLog().info("Hello, world.");
    }
}
