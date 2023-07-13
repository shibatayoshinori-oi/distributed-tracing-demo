rootProject.name = "distributed-tracing-demo"

includeBuild("spring-boot-2-b3") // B3のみサポート。既存のアプリケーションを想定。
includeBuild("spring-boot-2-b3-w3c-a") // B3, W3Cの両方をサポート。移行の途中段階（混在）を想定。
includeBuild("spring-boot-2-b3-w3c-b") // spring-boot-2-b3-w3c-aと同じ。分散トレーシングの確認のため別アプリケーションとして定義。
includeBuild("spring-boot-3-a") // デフォルト設定でB3, W3Cの両方をサポート。
includeBuild("spring-boot-3-b") // spring-boot-3-aと同じ。分散トレーシングの確認のため別アプリケーションとして定義。
