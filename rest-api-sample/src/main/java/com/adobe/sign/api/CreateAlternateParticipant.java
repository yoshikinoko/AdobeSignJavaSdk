/*
*  Copyright 2016 Adobe Systems Incorporated. All rights reserved.
*  This file is licensed to you under the Apache License, Version 2.0 (the "License");
*  you may not use this file except in compliance with the License. You may obtain a copy
*  of the License at http://www.apache.org/licenses/LICENSE-2.0
*
*  Unless required by applicable law or agreed to in writing, software distributed under
*  the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR REPRESENTATIONS
*  OF ANY KIND, either express or implied. See the License for the specific language
*  governing permissions and limitations under the License.
*
*/

package com.adobe.sign.api;

import com.adobe.sign.model.agreements.AlternateParticipantResponse;
import com.adobe.sign.utils.AgreementUtils;
import com.adobe.sign.utils.Constants;
import com.adobe.sign.utils.Errors;

/**
 * This sample client creates an alternate signer for the given agreement.
 *
 * <p>
 * <b>IMPORTANT</b>: Before running this sample, check that you have modified the 'Constants.java' file with the
 * appropriate values.
 * </p>
 */

public class CreateAlternateParticipant {

  /**
   * Entry point for this sample client program.
   */
  public static void main(String args[]) {
    try {
      CreateAlternateParticipant client = new CreateAlternateParticipant();
      client.run();
    }
    catch (Exception e) {
      throw new AssertionError(Errors.CREATE_ALTERNATE_PARTICIPANT);
    }
  }

  /**
   * Main work function. See the class comment for details.
   */
  private void run() throws Exception{
    //Get agreement ID
    String agreementId = AgreementUtils.getAgreementId(Constants.AGREEMENT_NAME);

    //Make API call to create alternate participant
    AlternateParticipantResponse alternateParticipantResponse = AgreementUtils.createAlternateParticipant(agreementId,
                                                                                                          Constants.ALTERNATE_PARTICIPANT_EMAIL,
                                                                                                          Constants.ALTERNATE_PARTICIPANT_MESSAGE);
    //Display information of alternate participant
    System.out.println("Alternate Participant ID = " + alternateParticipantResponse.getParticipantId());
  }
}