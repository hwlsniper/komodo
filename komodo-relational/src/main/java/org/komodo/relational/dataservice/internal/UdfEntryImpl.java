/*
 * JBoss, Home of Professional Open Source.
*
* See the LEGAL.txt file distributed with this work for information regarding copyright ownership and licensing.
*
* See the AUTHORS.txt file distributed with this work for a full listing of individual contributors.
*/
package org.komodo.relational.dataservice.internal;

import org.komodo.relational.Messages;
import org.komodo.relational.dataservice.UdfEntry;
import org.komodo.relational.internal.RelationalObjectImpl;
import org.komodo.relational.resource.UdfFile;
import org.komodo.relational.resource.internal.UdfFileImpl;
import org.komodo.spi.KException;
import org.komodo.spi.repository.KomodoObject;
import org.komodo.spi.repository.Repository;
import org.komodo.spi.repository.Repository.UnitOfWork;
import org.komodo.spi.repository.Repository.UnitOfWork.State;
import org.teiid.modeshape.sequencer.dataservice.lexicon.DataVirtLexicon;

/**
 * An implementation of a UDF entry in a data service.
 */
public class UdfEntryImpl extends RelationalObjectImpl implements UdfEntry {

    private static final String ARCHIVE_FOLDER = "udfs/"; //$NON-NLS-1$

    /**
     * @param uow
     *        the transaction (cannot be <code>null</code> and must have a state of {@link State#NOT_STARTED})
     * @param repository
     *        the repository where the relational object exists (cannot be <code>null</code>)
     * @param workspacePath
     *        the workspace relative path (cannot be empty)
     * @throws KException
     *         if an error occurs or if node at specified path is not a UDF entry
     */
    public UdfEntryImpl( final UnitOfWork uow,
                         final Repository repository,
                         final String workspacePath ) throws KException {
        super( uow, repository, workspacePath );
    }

    /**
     * {@inheritDoc}
     *
     * @see org.komodo.relational.dataservice.DataServiceResourceEntry#getArchiveFolder()
     */
    @Override
    public String getArchiveFolder() {
        return ARCHIVE_FOLDER;
    }

    /**
     * {@inheritDoc}
     *
     * @see org.komodo.relational.dataservice.DataServiceEntry#getReference(org.komodo.spi.repository.Repository.UnitOfWork)
     */
    @Override
    public UdfFile getReference( final UnitOfWork uow ) throws KException {
        if ( hasProperty( uow, DataVirtLexicon.ResourceEntry.RESOURCE_REF ) ) {
            final String resourceId = getProperty( uow, DataVirtLexicon.ResourceEntry.RESOURCE_REF ).getStringValue( uow );
            final KomodoObject kobj = getRepository().getUsingId( uow, resourceId );

            if ( kobj == null ) {
                throw new KException( Messages.getString( Messages.Relational.REFERENCED_RESOURCE_NOT_FOUND,
                                                          DataVirtLexicon.ResourceFile.UDF_FILE_NODE_TYPE,
                                                          resourceId ) );
            }

            return new UdfFileImpl( uow, getRepository(), kobj.getAbsolutePath() );
        }

        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see org.komodo.relational.dataservice.DataServiceResourceEntry#getResource(org.komodo.spi.repository.Repository.UnitOfWork)
     */
    @Override
    public UdfFile getResource( final UnitOfWork uow ) throws KException {
        return getReference( uow );
    }

}
