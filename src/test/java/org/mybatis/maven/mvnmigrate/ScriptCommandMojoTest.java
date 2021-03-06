/*
 *    Copyright 2010 The myBatis Team
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.mybatis.maven.mvnmigrate;

import java.io.File;

import org.apache.ibatis.migration.commands.ScriptCommand;

/**
 * @version $Id$
 */
@SuppressWarnings("unchecked")
public class ScriptCommandMojoTest extends AbstractMigrateTestCase {

    public void testScriptGoal() throws Exception {
        AbstractCommandMojo<ScriptCommand> mojo = (AbstractCommandMojo<ScriptCommand>) lookupMojo("script", testPom);
        assertNotNull(mojo);
        setVariableValueToObject(mojo, "v1", "20100400000001");
        setVariableValueToObject(mojo, "v2", "20100400000003");
        mojo.execute();
    }

    public void testScriptToFileGoal() throws Exception {
        AbstractCommandMojo<ScriptCommand> mojo = (AbstractCommandMojo<ScriptCommand>) lookupMojo("script", testPom);
        assertNotNull(mojo);
        setVariableValueToObject(mojo, "v1", "20100400000001");
        setVariableValueToObject(mojo, "v2", "20100400000003");
        setVariableValueToObject(mojo, "output", new File("target/script_20100400000001-20100400000003.sql"));
        mojo.execute();
        assertTrue(new File("target/script_20100400000001-20100400000003.sql").exists());
    }

}
