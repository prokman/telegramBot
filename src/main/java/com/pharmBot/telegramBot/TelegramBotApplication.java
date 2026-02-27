package com.pharmBot.telegramBot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TelegramBotApplication {

	public static void main(String[] args) {


		System.out.println("STARTING...");

		SpringApplication.run(TelegramBotApplication.class, args);
		System.out.println("STARTED...");}

		/*@Bean
		public CommandLineRunner checkBotCreation(ApplicationContext context) {
			return args -> {
				System.out.println("=== SPRING CONTEXT CHECK ===");

				// Проверяем, создан ли бот
				String[] botBeans = context.getBeanNamesForType(TelegramLongPollingBot.class);
				System.out.println("Found Telegram bots: " + botBeans.length);

				for (String beanName : botBeans) {
					System.out.println("Bot bean: " + beanName);
					Object bot = context.getBean(beanName);
					System.out.println("Bot class: " + bot.getClass().getSimpleName());
				}

				// Проверяем все бины
				String[] allBeans = context.getBeanDefinitionNames();
				System.out.println("Total beans: " + allBeans.length);

				boolean hasPharmBot = false;
				for (String beanName : allBeans) {
					if (beanName.toLowerCase().contains("pharm") ||
							beanName.toLowerCase().contains("bot")) {
						System.out.println("Found related bean: " + beanName);
						hasPharmBot = true;
					}
				}

				if (!hasPharmBot) {
					System.out.println("❌ PharmBot NOT found in Spring context!");
				} else {
					System.out.println("✅ PharmBot found in Spring context!");
				}
			};
		}*/
	}


