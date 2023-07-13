tasks.register("bootRunAll") {
    group = "application"
    description = "Runs all Spring Boot applications."
    dependsOn(gradle.includedBuild("spring-boot-2-b3").task(":bootRun"))
    dependsOn(gradle.includedBuild("spring-boot-2-b3-w3c-a").task(":bootRun"))
    dependsOn(gradle.includedBuild("spring-boot-2-b3-w3c-b").task(":bootRun"))
    dependsOn(gradle.includedBuild("spring-boot-3-a").task(":bootRun"))
    dependsOn(gradle.includedBuild("spring-boot-3-b").task(":bootRun"))
}