package org.convtool;

import org.convtool.core.ClassUtil;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

public class Convtool {

	private Convtool() {
	}

	/**
	 * 显示Convtool所有的工具类
	 */
	public static Set<Class<?>> getAllUtils() {
		try {
			return ClassUtil.getClassesFromJarFile("convtools-core.jar").stream()
					.filter(e -> e.getSimpleName().endsWith("Util"))
					.collect(Collectors.toSet());
		} catch (Exception e) {
			e.printStackTrace();
			return Collections.emptySet();
		}
	}

	/**
	 * 控制台打印所有工具类
	 */
	public static void main() {
		final Set<Class<?>> allUtils = getAllUtils();
		for (Class<?> clazz : allUtils) {
			System.out.println(clazz.getName());
		}
	}
}
