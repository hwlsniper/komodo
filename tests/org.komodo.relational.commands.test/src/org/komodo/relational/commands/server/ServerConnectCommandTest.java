/*
 * Copyright 2014 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.komodo.relational.commands.server;

import org.junit.Ignore;
import org.junit.Test;
import org.komodo.shell.api.CommandResult;
import org.komodo.shell.api.ShellCommand;
import org.komodo.spi.runtime.TeiidDataSource;
import org.komodo.spi.runtime.TeiidTranslator;
import org.komodo.spi.runtime.TeiidVdb;

/**
 * Test Class to test {@link ServerConnectCommand}.
 */
@SuppressWarnings( {"javadoc", "nls"} )
public final class ServerConnectCommandTest extends AbstractServerCommandTest {

    @Test
    public void shouldNotBeAvailableForServerNotDefined() throws Exception {
        this.assertCommandsNotAvailable(ServerConnectCommand.NAME);
    }
    
    @Test
    @Ignore
    public void shouldConnect() throws Exception {
        final String[] commands = {
            "set-auto-commit false",
            "create-teiid myTeiid",
            "commit",
            "set-server myTeiid" };
        CommandResult result = execute( commands );
        assertCommandResultOk(result);

        // Initialize a disconnected server
        initServer("myTeiid", true, false, 
                   new TeiidVdb[]{VDB1}, new TeiidDataSource[]{DS1}, 
                   new TeiidTranslator[]{TRANSLATOR1}, new String[]{DS_TYPE1});
        
        ShellCommand command = wsStatus.getCommand("server-connect");
        result = command.execute();
        assertCommandResultOk(result);
    }

}
