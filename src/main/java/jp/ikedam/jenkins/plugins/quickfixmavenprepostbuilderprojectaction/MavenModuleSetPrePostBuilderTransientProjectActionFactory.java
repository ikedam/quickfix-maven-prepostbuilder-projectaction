/*
 * The MIT License
 * 
 * Copyright (c) 2013 IKEDA Yasuyuki
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package jp.ikedam.jenkins.plugins.quickfixmavenprepostbuilderprojectaction;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import hudson.Extension;
import hudson.maven.MavenModuleSet;
import hudson.model.Action;
import hudson.model.TransientProjectActionFactory;
import hudson.model.AbstractProject;
import hudson.tasks.BuildStep;

/**
 *
 */
@Extension
public class MavenModuleSetPrePostBuilderTransientProjectActionFactory
        extends TransientProjectActionFactory
{
    /**
     * Call {@link BuildStep#getProjectActions(AbstractProject)} for prebuilders and postbuilders of {@link MavenModuleSet}.
     * 
     * @param target
     * @return
     * @see hudson.model.TransientProjectActionFactory#createFor(hudson.model.AbstractProject)
     */
    @Override
    public Collection<? extends Action> createFor(@SuppressWarnings("rawtypes") AbstractProject target)
    {
        if(!(target instanceof MavenModuleSet))
        {
            return null;
        }
        
        MavenModuleSet project = (MavenModuleSet)target;
        List<Action> actions = new ArrayList<Action>();
        
        if(project.getPrebuilders() != null)
        {
            for(BuildStep b: project.getPrebuilders())
            {
                actions.addAll(b.getProjectActions(project));
            }
        }
        if(project.getPostbuilders() != null)
        {
            for(BuildStep b: project.getPostbuilders())
            {
                actions.addAll(b.getProjectActions(project));
            }
        }
        
        return actions;
    }
}
