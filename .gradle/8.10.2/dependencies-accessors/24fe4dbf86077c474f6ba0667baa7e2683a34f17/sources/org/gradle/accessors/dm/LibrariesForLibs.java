package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.MinimalExternalModuleDependency;
import org.gradle.plugin.use.PluginDependency;
import org.gradle.api.artifacts.ExternalModuleDependencyBundle;
import org.gradle.api.artifacts.MutableVersionConstraint;
import org.gradle.api.provider.Provider;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.internal.catalog.AbstractExternalDependencyFactory;
import org.gradle.api.internal.catalog.DefaultVersionCatalog;
import java.util.Map;
import org.gradle.api.internal.attributes.ImmutableAttributesFactory;
import org.gradle.api.internal.artifacts.dsl.CapabilityNotationParser;
import javax.inject.Inject;

/**
 * A catalog of dependencies accessible via the {@code libs} extension.
 */
@NonNullApi
public class LibrariesForLibs extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final JunitLibraryAccessors laccForJunitLibraryAccessors = new JunitLibraryAccessors(owner);
    private final OrgLibraryAccessors laccForOrgLibraryAccessors = new OrgLibraryAccessors(owner);
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForLibs(DefaultVersionCatalog config, ProviderFactory providers, ObjectFactory objects, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) {
        super(config, providers, objects, attributesFactory, capabilityNotationParser);
    }

    /**
     * Group of libraries at <b>junit</b>
     */
    public JunitLibraryAccessors getJunit() {
        return laccForJunitLibraryAccessors;
    }

    /**
     * Group of libraries at <b>org</b>
     */
    public OrgLibraryAccessors getOrg() {
        return laccForOrgLibraryAccessors;
    }

    /**
     * Group of versions at <b>versions</b>
     */
    public VersionAccessors getVersions() {
        return vaccForVersionAccessors;
    }

    /**
     * Group of bundles at <b>bundles</b>
     */
    public BundleAccessors getBundles() {
        return baccForBundleAccessors;
    }

    /**
     * Group of plugins at <b>plugins</b>
     */
    public PluginAccessors getPlugins() {
        return paccForPluginAccessors;
    }

    public static class JunitLibraryAccessors extends SubDependencyFactory {

        public JunitLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>junit</b> with <b>junit:junit</b> coordinates and
         * with version reference <b>junit.junit</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJunit() {
            return create("junit.junit");
        }

    }

    public static class OrgLibraryAccessors extends SubDependencyFactory {
        private final OrgSonarsourceLibraryAccessors laccForOrgSonarsourceLibraryAccessors = new OrgSonarsourceLibraryAccessors(owner);

        public OrgLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.sonarsource</b>
         */
        public OrgSonarsourceLibraryAccessors getSonarsource() {
            return laccForOrgSonarsourceLibraryAccessors;
        }

    }

    public static class OrgSonarsourceLibraryAccessors extends SubDependencyFactory {
        private final OrgSonarsourceScannerLibraryAccessors laccForOrgSonarsourceScannerLibraryAccessors = new OrgSonarsourceScannerLibraryAccessors(owner);

        public OrgSonarsourceLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.sonarsource.scanner</b>
         */
        public OrgSonarsourceScannerLibraryAccessors getScanner() {
            return laccForOrgSonarsourceScannerLibraryAccessors;
        }

    }

    public static class OrgSonarsourceScannerLibraryAccessors extends SubDependencyFactory {
        private final OrgSonarsourceScannerMavenLibraryAccessors laccForOrgSonarsourceScannerMavenLibraryAccessors = new OrgSonarsourceScannerMavenLibraryAccessors(owner);

        public OrgSonarsourceScannerLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.sonarsource.scanner.maven</b>
         */
        public OrgSonarsourceScannerMavenLibraryAccessors getMaven() {
            return laccForOrgSonarsourceScannerMavenLibraryAccessors;
        }

    }

    public static class OrgSonarsourceScannerMavenLibraryAccessors extends SubDependencyFactory {
        private final OrgSonarsourceScannerMavenSonarLibraryAccessors laccForOrgSonarsourceScannerMavenSonarLibraryAccessors = new OrgSonarsourceScannerMavenSonarLibraryAccessors(owner);

        public OrgSonarsourceScannerMavenLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.sonarsource.scanner.maven.sonar</b>
         */
        public OrgSonarsourceScannerMavenSonarLibraryAccessors getSonar() {
            return laccForOrgSonarsourceScannerMavenSonarLibraryAccessors;
        }

    }

    public static class OrgSonarsourceScannerMavenSonarLibraryAccessors extends SubDependencyFactory {
        private final OrgSonarsourceScannerMavenSonarMavenLibraryAccessors laccForOrgSonarsourceScannerMavenSonarMavenLibraryAccessors = new OrgSonarsourceScannerMavenSonarMavenLibraryAccessors(owner);

        public OrgSonarsourceScannerMavenSonarLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.sonarsource.scanner.maven.sonar.maven</b>
         */
        public OrgSonarsourceScannerMavenSonarMavenLibraryAccessors getMaven() {
            return laccForOrgSonarsourceScannerMavenSonarMavenLibraryAccessors;
        }

    }

    public static class OrgSonarsourceScannerMavenSonarMavenLibraryAccessors extends SubDependencyFactory {

        public OrgSonarsourceScannerMavenSonarMavenLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>plugin</b> with <b>org.sonarsource.scanner.maven:sonar-maven-plugin</b> coordinates and
         * with version reference <b>org.sonarsource.scanner.maven.sonar.maven.plugin</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getPlugin() {
            return create("org.sonarsource.scanner.maven.sonar.maven.plugin");
        }

    }

    public static class VersionAccessors extends VersionFactory  {

        private final JunitVersionAccessors vaccForJunitVersionAccessors = new JunitVersionAccessors(providers, config);
        private final OrgVersionAccessors vaccForOrgVersionAccessors = new OrgVersionAccessors(providers, config);
        public VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.junit</b>
         */
        public JunitVersionAccessors getJunit() {
            return vaccForJunitVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org</b>
         */
        public OrgVersionAccessors getOrg() {
            return vaccForOrgVersionAccessors;
        }

    }

    public static class JunitVersionAccessors extends VersionFactory  {

        public JunitVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>junit.junit</b> with value <b>4.12</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getJunit() { return getVersion("junit.junit"); }

    }

    public static class OrgVersionAccessors extends VersionFactory  {

        private final OrgSonarsourceVersionAccessors vaccForOrgSonarsourceVersionAccessors = new OrgSonarsourceVersionAccessors(providers, config);
        public OrgVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.sonarsource</b>
         */
        public OrgSonarsourceVersionAccessors getSonarsource() {
            return vaccForOrgSonarsourceVersionAccessors;
        }

    }

    public static class OrgSonarsourceVersionAccessors extends VersionFactory  {

        private final OrgSonarsourceScannerVersionAccessors vaccForOrgSonarsourceScannerVersionAccessors = new OrgSonarsourceScannerVersionAccessors(providers, config);
        public OrgSonarsourceVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.sonarsource.scanner</b>
         */
        public OrgSonarsourceScannerVersionAccessors getScanner() {
            return vaccForOrgSonarsourceScannerVersionAccessors;
        }

    }

    public static class OrgSonarsourceScannerVersionAccessors extends VersionFactory  {

        private final OrgSonarsourceScannerMavenVersionAccessors vaccForOrgSonarsourceScannerMavenVersionAccessors = new OrgSonarsourceScannerMavenVersionAccessors(providers, config);
        public OrgSonarsourceScannerVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.sonarsource.scanner.maven</b>
         */
        public OrgSonarsourceScannerMavenVersionAccessors getMaven() {
            return vaccForOrgSonarsourceScannerMavenVersionAccessors;
        }

    }

    public static class OrgSonarsourceScannerMavenVersionAccessors extends VersionFactory  {

        private final OrgSonarsourceScannerMavenSonarVersionAccessors vaccForOrgSonarsourceScannerMavenSonarVersionAccessors = new OrgSonarsourceScannerMavenSonarVersionAccessors(providers, config);
        public OrgSonarsourceScannerMavenVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.sonarsource.scanner.maven.sonar</b>
         */
        public OrgSonarsourceScannerMavenSonarVersionAccessors getSonar() {
            return vaccForOrgSonarsourceScannerMavenSonarVersionAccessors;
        }

    }

    public static class OrgSonarsourceScannerMavenSonarVersionAccessors extends VersionFactory  {

        private final OrgSonarsourceScannerMavenSonarMavenVersionAccessors vaccForOrgSonarsourceScannerMavenSonarMavenVersionAccessors = new OrgSonarsourceScannerMavenSonarMavenVersionAccessors(providers, config);
        public OrgSonarsourceScannerMavenSonarVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.sonarsource.scanner.maven.sonar.maven</b>
         */
        public OrgSonarsourceScannerMavenSonarMavenVersionAccessors getMaven() {
            return vaccForOrgSonarsourceScannerMavenSonarMavenVersionAccessors;
        }

    }

    public static class OrgSonarsourceScannerMavenSonarMavenVersionAccessors extends VersionFactory  {

        public OrgSonarsourceScannerMavenSonarMavenVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.sonarsource.scanner.maven.sonar.maven.plugin</b> with value <b>3.9.0.2155</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getPlugin() { return getVersion("org.sonarsource.scanner.maven.sonar.maven.plugin"); }

    }

    public static class BundleAccessors extends BundleFactory {

        public BundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

    }

    public static class PluginAccessors extends PluginFactory {

        public PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

    }

}
