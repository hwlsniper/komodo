/*
* JBoss, Home of Professional Open Source.
*
* See the LEGAL.txt file distributed with this work for information regarding copyright ownership and licensing.
*
* See the AUTHORS.txt file distributed with this work for a full listing of individual contributors.
*/
package org.komodo.rest.relational.json;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import java.net.URI;
import java.util.Arrays;
import java.util.List;
import javax.ws.rs.core.UriBuilder;
import org.junit.Before;
import org.junit.Test;
import org.komodo.rest.json.JsonConstants;
import org.komodo.rest.relational.RestVdbDataRole;
import org.komodo.spi.repository.KomodoType;

@SuppressWarnings( {"javadoc", "nls"} )
public final class VdbDataRoleSerializerTest implements JsonConstants {

    private static final URI BASE_URI = UriBuilder.fromUri("http://localhost:8081/v1/workspace/").build();
    private static final String PARENT_VDB = "vdb1";
    private static final String NAME = "MyDataRole";
    private static final String DESCRIPTION = "my description";
    private static final String ROLE_DATA_PATH = "/workspace/vdb1/vdbDataRoles/MyDataRole";
    private static final String PERMISSIONS_DATA_PATH = ROLE_DATA_PATH + "/permissions";
    private static final boolean ALLOW_CREATE_TEMP_TABLES = true;
    private static final boolean ANY_AUTHENTICATED = false;
    private static final boolean GRANT_ALL = false;
    private static final List<String> MAPPED_ROLES = Arrays.asList("larry", "curly", "moe");

    private static final String JSON = EMPTY_STRING +
        OPEN_BRACE + NEW_LINE +
        "  \"" + ID + "\": \"" + NAME + "\"," + NEW_LINE +
        "  \"" + DATA_PATH + "\": \"" + ROLE_DATA_PATH + "\"," + NEW_LINE +
        "  \"" + KTYPE + "\": \"" + KomodoType.VDB_DATA_ROLE.getType() + "\"," + NEW_LINE +
        "  \"" + HAS_CHILDREN + "\": true," + NEW_LINE +
        "  \"vdb__dataRole\": \"" + NAME + "\"," + NEW_LINE +
        "  \"vdb__description\": \"" + DESCRIPTION + "\"," + NEW_LINE +
        "  \"vdb__allowCreateTemporaryTables\": true," + NEW_LINE +
        "  \"vdb__anyAuthenticated\": false," + NEW_LINE +
        "  \"vdb__grantAll\": false," + NEW_LINE +
        "  \"vdb__mappedRoleNames\": [" + NEW_LINE +
        "    \"larry\"," + NEW_LINE +
        "    \"curly\"," + NEW_LINE +
        "    \"moe\"" + NEW_LINE +
        "  ]," + NEW_LINE +
        "  \"" + LINKS + "\": " + OPEN_SQUARE_BRACKET + NEW_LINE +
        "    " + OPEN_BRACE + NEW_LINE +
        "      \"rel\": \"self\"," + NEW_LINE +
        "      \"href\": \"http://localhost:8081/v1/workspace/workspace/vdbs/vdb1/VdbDataRoles/MyDataRole\"" + NEW_LINE +
        "    " + CLOSE_BRACE + COMMA + NEW_LINE +
        "    " + OPEN_BRACE + NEW_LINE +
        "      \"rel\": \"parent\"," + NEW_LINE +
        "      \"href\": \"http://localhost:8081/v1/workspace/workspace/vdbs/vdb1\"" + NEW_LINE +
        "    " + CLOSE_BRACE + COMMA + NEW_LINE +
        "    " + OPEN_BRACE + NEW_LINE +
        "      \"rel\": \"permissions\"," + NEW_LINE +
        "      \"href\": \"http://localhost:8081/v1/workspace/workspace/vdbs/vdb1/VdbDataRoles/MyDataRole/VdbPermissions\"" + NEW_LINE +
        "    " + CLOSE_BRACE + NEW_LINE +
        "  " + CLOSE_SQUARE_BRACKET + NEW_LINE +
        CLOSE_BRACE;

    private RestVdbDataRole dataRole;

    @Before
    public void init() {
        this.dataRole = new RestVdbDataRole(BASE_URI, NAME, ROLE_DATA_PATH,
                                                                        KomodoType.VDB_DATA_ROLE, true, PARENT_VDB);
        this.dataRole.setName(NAME);
        this.dataRole.setDescription(DESCRIPTION);
        this.dataRole.setAllowCreateTempTables(ALLOW_CREATE_TEMP_TABLES);
        this.dataRole.setAnyAuthenticated(ANY_AUTHENTICATED);
        this.dataRole.setGrantAll(GRANT_ALL);
        this.dataRole.setMappedRoles(MAPPED_ROLES.toArray(new String[MAPPED_ROLES.size()]));
    }

    @Test
    public void shouldExportJson() {
        String json = KomodoJsonMarshaller.marshall(this.dataRole);
        assertEquals(JSON, json);
    }

    @Test
    public void shouldImportJson() {
        final RestVdbDataRole dataRole = KomodoJsonMarshaller.unmarshall(JSON, RestVdbDataRole.class);
        assertThat(dataRole.getDescription(), is(DESCRIPTION));
        assertThat(dataRole.getName(), is(NAME));
        assertThat(dataRole.isAllowCreateTempTables(), is(ALLOW_CREATE_TEMP_TABLES));
        assertThat(dataRole.isAnyAuthenticated(), is(ANY_AUTHENTICATED));
        assertThat(dataRole.isGrantAll(), is(GRANT_ALL));
        assertThat(dataRole.getLinks().size(), is(3));
        assertThat(dataRole.getProperties().isEmpty(), is(true));
        assertThat(dataRole.getMappedRoles().length, is(MAPPED_ROLES.size()));
    }

    @Test( expected = Exception.class )
    public void shouldNotExportWhenNameIsMissing() {
        final RestVdbDataRole incomplete = new RestVdbDataRole();
        KomodoJsonMarshaller.marshall(incomplete);
    }

    @Test( expected = Exception.class )
    public void shouldNotImportJsonWhenIdIsMissing() {
        final String malformed = "{\"description\":\"my description\"anyAuthenticated,\"allowCreateTempTables\":true,\"grantAll\":false,\"mappedRoles\":[\"larry\",\"curly\",\"moe\"]}";
        KomodoJsonMarshaller.unmarshall(malformed, RestVdbDataRole.class);
    }

}