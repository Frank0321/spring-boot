/**
 * @Description : 將 string 轉成 json
 * @ClassName : JsonFormatUtils.java
 * @Copyright : Copyright (c) 2023 
 * @ModifyHistory : 
 *  v1.00, 2023/02/25, frankchang
 *   1) First Release.
 */

package com.example.springboot.utils;

public class JsonFormatUtils {

	public static final String SPACE = "    ";

	public static String formatJson(String json) {

		if (json.contains("\r") || json.contains("\n")) {
			// 如果為 json 字樣，則不處理
			return json;
			
		} else {
			
			StringBuffer result = new StringBuffer();

			int length = json.length();
			int number = 0;
			char key = 0;

			for (int count = 0; count < length; count++) {

				// 1. 取得目前第一個當前字符
				key = json.charAt(count);

				// 2. 檢核當前字串是否為'['或是'{'
				if (key == '[' || key == '{') {

					// 2-1. 如果當前前方還有資料，且為':'
					if ((count - 1) > 0 && json.charAt(count - 1) == ':') {
						result.append('\n');
						result.append(whiteSpace(number));
					}

					result.append(key);
					result.append('\n');

					number++;
					result.append(whiteSpace(number));

					continue;
				}

				// 3. 檢核當前字串是否為']'或是'}'
				if (key == ']' || key == '}') {

					result.append('\n');

					number--;
					result.append(whiteSpace(number));

					result.append(key);

					continue;
				}

				if (key == ',') {

					result.append(key);
					result.append('\n');
					result.append(whiteSpace(number));
					continue;
				}

				if (key == '\\') {

					if (json.charAt(count + 1) == '"') {
						continue;
					}
				}

				if (key == ' ') {
					continue;
				}

				result.append(key);
			}

			return result.toString();
		}
	}

	private static String whiteSpace(int number) {

		StringBuffer result = new StringBuffer();

		for (int count = 0; count < number; count++) {
			result.append(SPACE);
		}

		return result.toString();
	}
}
