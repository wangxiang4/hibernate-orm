/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.jpa.boot.spi;

import org.hibernate.boot.spi.MetadataBuilderContributor;

/**
 * Enumerates SPI-related settings that are specific to the use of Hibernate
 * as a JPA {@link jakarta.persistence.spi.PersistenceProvider}.
 *
 * @author Gavin King
 *
 * @since 6.2
 */
public class JpaSettings {

	/**
	 * Names a {@link IntegratorProvider}
	 */
	public static final String INTEGRATOR_PROVIDER = "hibernate.integrator_provider";

	/**
	 * Names a {@link StrategyRegistrationProviderList}
	 */
	public static final String STRATEGY_REGISTRATION_PROVIDERS = "hibernate.strategy_registration_provider";

	/**
	 * Names a {@link TypeContributorList}
	 */
	public static final String TYPE_CONTRIBUTORS = "hibernate.type_contributors";

	/**
	 * Names a {@link MetadataBuilderContributor}
	 */
	public static final String METADATA_BUILDER_CONTRIBUTOR = "hibernate.metadata_builder_contributor";

}
