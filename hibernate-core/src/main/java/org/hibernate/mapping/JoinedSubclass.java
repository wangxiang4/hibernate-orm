/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.mapping;
import java.util.Iterator;
import java.util.List;

import org.hibernate.MappingException;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.spi.MetadataBuildingContext;

/**
 * A mapping model object that represents a subclass in a "joined" or
 * {@linkplain jakarta.persistence.InheritanceType#JOINED "table per subclass"}
 * inheritance hierarchy.
 *
 * @author Gavin King
 */
public class JoinedSubclass extends Subclass implements TableOwner {
	private Table table;
	private KeyValue key;

	public JoinedSubclass(PersistentClass superclass, MetadataBuildingContext metadataBuildingContext) {
		super( superclass, metadataBuildingContext );
	}

	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
		getSuperclass().addSubclassTable( table );
	}

	public KeyValue getKey() {
		return key;
	}

	public void setKey(KeyValue key) {
		this.key = key;
	}

	public void validate(Metadata mapping) throws MappingException {
		super.validate(mapping);
		if ( key != null && !key.isValid( mapping ) ) {
			throw new MappingException(
					"subclass key mapping has wrong number of columns: " +
					getEntityName() +
					" type: " +
					key.getType().getName()
				);
		}
	}

	@Deprecated @SuppressWarnings("deprecation")
	public Iterator<Property> getReferenceablePropertyIterator() {
		return getPropertyIterator();
	}

	public List<Property> getReferenceableProperties() {
		return getProperties();
	}

	public Object accept(PersistentClassVisitor mv) {
		return mv.accept(this);
	}
}
