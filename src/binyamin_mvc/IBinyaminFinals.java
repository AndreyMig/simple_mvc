package binyamin_mvc;

public interface IBinyaminFinals {

	public enum MyEnum {

		SUFFIX_INIT("sada"), SUFFIX_LOADING("sada"), SUFFIX_LOADED("234"), SUFFIX_PENDING(
				"sfsdf"), SUFFIX_ENDED("3h34"), SUFFIX_CANCELED("sdf"), SUFFIX_APPROVED("t43535");


		private String suffix;

		MyEnum(String suffix) {

			this.suffix = suffix;
		}

		// MyEnum getCurrentEnum

		String getSuffix() {
			return this.suffix;
		}

	}

}
