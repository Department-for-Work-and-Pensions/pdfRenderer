package test_data

import scala.xml.Elem


object XMLData {
  def madeUpField(xml: Elem) = {
    Seq(
      "I am an invalid field that should never appear in the pdf"
    )
  }

  def functionalTestCaseSectionPart1AboutYouTheCarer(xml: Elem) = {
    sectionPart1AboutYouTheCarer(xml)
  }

  def functionalTestCase1(xml: Elem) = {
    val fields = XMLDataFields(xml)
    functionalTestCaseMandatoryFields(xml)
  }

  def functionalTestCase2(xml: Elem) = {
    val fields = XMLDataFields(xml)
    Seq(
      "Other surname or maiden name " + fields.claimantOtherSurnames.text,
      "Other surname or maiden name " + fields.partnerOtherSurnames.text
    ) ++ functionalTestCaseMandatoryFields(xml) ++ aboutYourPartner(fields)
  }

  def functionalTestCase3(xml: Elem) = {
    val fields = XMLDataFields(xml)
    Seq(
      "Other surname or maiden name " + fields.claimantOtherSurnames.text,
      "Other surname or maiden name " + fields.partnerOtherSurnames.text
    ) ++ functionalTestCaseMandatoryFields(xml) ++ aboutYourPartner(fields) ++ careBreaks(fields)
  }

  def functionalTestCase4(xml: Elem): Seq[String] = {
    val fields = XMLDataFields(xml)
    Seq(
      "Other surname or maiden name " + fields.claimantOtherSurnames.text
    ) ++ functionalTestCaseMandatoryFields(xml) ++ careBreaks(fields)
  }

  def functionalTestCase5(xml: Elem) = {
    val fields = XMLDataFields(xml)
    functionalTestCaseMandatoryFields(xml) ++ aboutYourPartner(fields) ++ careBreaks(fields)
  }

  def functionalTestCase6(xml: Elem) = {
    val fields = XMLDataFields(xml)
    functionalTestCaseMandatoryFields(xml)
  }

  def functionalTestCase7(xml: Elem) = {
    val fields = XMLDataFields(xml)
    functionalTestCaseMandatoryFields(xml) ++ aboutYourPartner(fields) ++ careBreaks(fields)
  }

  def functionalTestCase8(xml: Elem) = {
    val fields = XMLDataFields(xml)
    functionalTestCaseMandatoryFields(xml)
  }

  def functionalTestCase9(xml: Elem) = {
    val fields = XMLDataFields(xml)
    functionalTestCaseMandatoryFields(xml)
  }

  def functionalTestCaseMandatoryFields(xml: Elem) = {
    val fields = XMLDataFields(xml)
    Seq(
      "Transaction: " + fields.transactionPath.text + " " + fields.title.text + " " + fields.surName.text + " " + fields.nationalInsuranceNumber.text,
      "Summary"
    ) ++ aboutYouTheCarer(fields) ++ aboutTheCareYouProvide(fields) ++ claimDates(fields) ++ claimSummary(fields)
  }

  def aboutYouTheCarer(fields: XMLDataFields) = {
    Seq("About you - the carer",
      "National Insurance Number " + fields.nationalInsuranceNumber.text,
      "Last name " + fields.surName.text,
      "First name(s) " + fields.firstName.text,
      "Title " + fields.title.text,
      "Street / Town / City " + fields.addressCarer,
      "Postcode " + fields.postCodeCarer.text
    )
  }

  def aboutTheCareYouProvide(fields: XMLDataFields) = {
    Seq(
      "About the care you provide",
      "Last name " + fields.careeLastName.text,
      "First name(s) " + fields.careeFirstName.text,
      "Title " + fields.careeTitle.text,
      "Street / Town / City " + fields.addressCaree,
      "Postcode " + fields.postCodeCaree.text
    )
  }

  def claimDates(fields: XMLDataFields) = {
    Seq("Claim Dates",
      "Date claim received " + fields.dateClaimReceived.text
    )
  }

  def claimSummary(fields: XMLDataFields) = {
    Seq("Claim Summary",
      "Transaction: " + fields.transactionPath.text + " " + "Claim received: " + fields.dateClaimReceived.text
    )
  }

  def aboutYourPartner(fields: XMLDataFields) = Seq(
    "National Insurance Number " + fields.parnerNINO.text,
    "Last name " + fields.partnerSurname.text,
    "First name(s) " + fields.partnerOtherNames.text,
    "Title " + fields.partnerTitle.text
  )

  def careBreaks(fields: XMLDataFields) = fields.careBreak

  def sectionPart1AboutYouTheCarer(xml: Elem) = {
    val fields = SectionPart1AboutYouTheCarer(xml);
    Seq("Part 1 - About you - the carer",
      //"Your details",
      "Title " + fields.title.text,
      "First Name " + fields.firstName.text,
      "Last Name "+ fields.lastName.text,
//      "Other surname or maiden name" + fields..text,
//      "National Insurance number" + fields..text,
//      "Date of Birth" + fields..text,
//      "Martial Status" + fields..text,
//      "When do you want your Carer’s Allowance claim to start?" + fields..text,
//      "Your contact details",
      "Street / Town / City " + fields.address,
      "Postcode " + fields.postCode.text
//      "Daytime telephone number" + fields..text,
//      "Mobile number" + fields..text,
//      "If you have speech or hearing difficulties, would you like us to contact you by textphone?" + fields..text,
//      "Your nationality and residency",
//      "What is your nationality" + fields..text,
//      "Do you live in England, Scotland or Wales" + fields..text,
//      "Which country do you normally live in" + fields..text,
//      "Time outside of England, Scotland or Wales" + fields..text,
//      "Have you spent any time outside England, Scotland or Wales in the last 3 years before your claim date <<ddmmyyyy>>?" + fields..text,
//      "Outside England, Scotland and Wales",
//      "Which country did you go to?" + fields..text,
//      "Date you left" + fields..text,
//      "Date you returned" + fields..text,
//      "Reason for being there?" + fields..text,
//      "Other" + fields..text,
//      "Was the person you care for with you?" + fields..text,
//      "Money you get from other European Economic Area (EEA) countries or Switzerland",
//      "Do you, or any member of your family, receive any benefits or pensions from a European Economic Area (EEA) state or Switzerland?" + fields..text,
//      "Have you, or a member  of your family, made a claim for any benefits or pensions from a European Economic Area (EEA) state or Switzerland?" + fields..text,
//      "Are you, or a member of your family, working in or paying insurance to, another European Economic Area (EEA) state or Switzerland?" + fields..text,
//      "More about you",
//      "Have you had a partner/spouse living with you since your claim date?: <ddmmyyyy>?" + fields..text,
//      "Have you been on a course of education since your claim date:<ddmmyyyy>? Have you been on a course of education since your claim date:<ddmmyyyy>? Have you been on a course of education since your claim date:<ddmmyyyy>? Have you been on a course of education since your claim date:<ddmmyyyy>? Have you been on a course of education since your claim date:<ddmmyyyy>? Have you been on a course of education since your claim date:<ddmmyyyy>? Have you been on a course of education since your claim date:<ddmmyyyy>? Have you been on a course of education since your claim date:<ddmmyyyy>? Have you been on a course of education since your claim date:<ddmmyyyy>? Have you been on a course of education since your claim date:<ddmmyyyy>? Have you been on a course of education since your claim date:<ddmmyyyy>? Have you been on a course of education since your claim date:<ddmmyyyy>? Have you been on a course of education since your claim date:<ddmmyyyy>? Have you been on a course of education since your claim date:<ddmmyyyy>? Have you been on a course of education since your claim date:<ddmmyyyy>? Have you been on a course of education since your claim date:<ddmmyyyy>?" + fields..text,
//      "Do you get State Pension?" + fields.,
//      "Employment",
//      "Have you been employed at any time since <ddmmyyyy_1> (this is six months before your claim date:< ddmmyyyy>)?" + fields..text,
//      "Have you been self-employed at any time since <ddmmyyyy_2> (this is one week before your claim date:<ddmmyyyy>)?" + fields..text,

    )
  }

}
