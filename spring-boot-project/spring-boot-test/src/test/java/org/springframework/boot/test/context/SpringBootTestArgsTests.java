/*
 * Copyright 2012-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.boot.test.context;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Assert that tests annotated with {@link SpringBootTest} can specify
 * {@link SpringBootTest#args()} to be passed to their application under test.
 *
 * @author Justin Griffin
 */
@RunWith(SpringRunner.class)
@SpringBootTest(args = { "--option.foo=option-foo-value", "other.bar=other-bar-value" })
public class SpringBootTestArgsTests {

	@Autowired
	private ApplicationArguments args;

	@Test
	public void applicationArgumentsPopulated() {
		assertThat(this.args.getOptionNames()).contains("option.foo");
		assertThat(this.args.getNonOptionArgs()).contains("other.bar=other-bar-value");
	}

	@Configuration
	protected static class Config {

	}

}
