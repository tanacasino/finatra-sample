package com.github.tanacasino.hello

import com.twitter.finatra.validation._

case class HiRequest(
    @Range(min = 1, max = 1000) id: Long,
    @NotEmpty name: String
) {

  @MethodValidation
  def validateName = {
    ValidationResult(
      name.startsWith("name-"),
      "name must starts with 'name-'"
    )
  }

}

