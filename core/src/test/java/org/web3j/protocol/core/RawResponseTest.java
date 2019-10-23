/*
 * Copyright 2019 Web3 Labs Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.web3j.protocol.core;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.web3j.protocol.ResponseTester;
import org.web3j.protocol.core.methods.response.EthBlock;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;

/** Raw Response tests. */
public class RawResponseTest extends ResponseTester {

  private static final String RAW_RESPONSE =
      "{\n"
      + "  \"id\":67,\n"
      + "  \"jsonrpc\":\"2.0\",\n"
      + "  \"result\": \"Mist/v0.9.3/darwin/go1.4.1\"\n"
      + "}";

  private static final String LARGE_RAW_RESPONSE =
      "{\"jsonrpc\":\"2.0\",\"id\":1,\"result\":{\"difficulty\":\"0x1aea99\",\"extraData\":\"0xd5830104028650617269747986312e31322e31826c69\",\"gasLimit\":\"0x47b760\",\"gasUsed\":\"0x21c687\",\"hash\":\"0xee5b9e9030d308c77a2d4f975b7090a026ac2cdfe9669e2452cedb4c82e8285e\",\"logsBloom\":\"0x00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000\",\"miner\":\"0x004355941066a10e81641d660e0b7082176dfdc0\",\"mixHash\":\"0x0f15a659a35b19fc053b2d3202274ea010ff4125899e18f3197544ec7f53feda\",\"nonce\":\"0x12969144f99ecad6\",\"number\":\"0xc9e\",\"parentHash\":\"0xb4c2c0218039582ce398f2e6e6b325baa62348ee486abb259ea71a9b7afdd125\",\"receiptsRoot\":\"0xb52507949b00d49ae98e6918f80813df0ce6cc62e87bff83387dce37bee0ed7f\",\"sha3Uncles\":\"0x1dcc4de8dec75d7aab85b567b6ccd41ad312451b948a7413f0a142fd40d49347\",\"size\":\"0x21fe\",\"stateRoot\":\"0x3e3e38f228413700e8c88f87edc51bf696e10652909cd32f6ac87f425c885948\",\"timestamp\":\"0x5832272b\",\"totalDifficulty\":\"0xdf702046\",\"transactions\":[{\"blockHash\":\"0xee5b9e9030d308c77a2d4f975b7090a026ac2cdfe9669e2452cedb4c82e8285e\",\"blockNumber\":\"0xc9e\",\"from\":\"0x0718197b9ac69127381ed0c4b5d0f724f857c4d1\",\"gas\":\"0x3d0900\",\"gasPrice\":\"0x0\",\"hash\":\"0x0a00ca4ab70707c097381f5f83c08eac50c4c8a8f9bf025d407b0d71703c5971\",\"input\":\"0x6060604052600180546c0100000000000000000000000033810204600160a060020a03199182168117909255600280549091169091179055611f4c806100456000396000f3606060405236156100a35760e060020a600035046304029f2381146100a85780631f9ea25d1461012057806349593f5314610148578063569aa0d81461025257806359a4669f14610384578063656104f51461047357806370de8c6e1461049b57806371bde8521461057b5780638d909ad9146106455780638f30435d14610730578063916dbc1714610787578063c91540f6146108c0578063fedc2a2814610b95575b610002565b3461000257610c6e6004808035906020019082018035906020019191908080601f01602080910402602001604051908101604052809392919081815260200183838082843750949650509335935050604435915050606435600154600090819033600160a060020a03908116911614610f7b57610002565b3461000257610c6e600435600254600160a060020a0390811633919091161461102a57610002565b3461000257610c6e6004808035906020019082018035906020019191908080601f0160208091040260200160405190810160405280939291908181526020018383808284375094965050933593505060443591505060643560843560006000600060006000600060006000508b604051808280519060200190808383829060006004602084601f0104600302600f01f1509050019150509081526020016040518091039020600050955085600001600050600033600160a060020a0316815260200190815260200160002060005094508967ffffffffffffffff168560000160059054906101000a900467ffffffffffffffff1667ffffffffffffffff161415156111ff576111f2565b3461000257610c706004808035906020019082018035906020019191908080601f01602080910402602001604051908101604052809392919081815260200183838082843750949650509335935050604435915050600060006000600060006000600060006000508a604051808280519060200190808383829060006004602084601f0104600302600f01f15090500191505090815260200160405180910390206000506001016000508960ff1660028110156100025760060201600050600160a060020a0389166000908152600491909101602052604090208054600182015463ffffffff8083169a5067ffffffffffffffff606060020a840481169a50640100000000840482169950919750604060020a830416955060a060020a90910416925090505093975093979195509350565b610c6e6004808035906020019082018035906020019191908080601f016020809104026020016040519081016040528093929190818152602001838380828437509496505050505050506000600060005082604051808280519060200190808383829060006004602084601f0104600302600f01f15090500191505090815260200160405180910390206000509050348160010160005082600d0160009054906101000a900460ff1660ff16600281101561000257600602016000506002018054608060020a6001608060020a0382169093018302929092046001608060020a03199092169190911790555050565b3461000257610c6e600435600154600160a060020a039081163391909116146113c857610002565b610c6e6004808035906020019082018035906020019191908080601f0160208091040260200160405190810160405280939291908181526020018383808284375094965050933593505060443591505060643560006000600060005086604051808280519060200190808383829060006004602084601f0104600302600f01f15090500191505090815260200160405180910390206000509150816001016000508460ff16600281101561000257600602016000506001810154909150346affffffffffffffffffffff608060020a90920491909116146113e757610002565b610c6e6004808035906020019082018035906020019191908080601f01602080910402602001604051908101604052809392919081815260200183838082843750506040805161012435808a013560208181028481018201909552818452989a8a359a6044359a6064359a50608435995060a435985060c435975060e4359661010435969395610144959301929182919085019084908082843750949650505050505050600154600090819081908190819033600160a060020a0390811691161461160f57610002565b3461000257610cba6004808035906020019082018035906020019191908080601f0160208091040260200160405190810160405280939291908181526020018383808284375094965050933593505050506000600060006000600060006000600060006000600060006000508d604051808280519060200190808383829060006004602084601f0104600302600f01f1509050019150509081526020016040518091039020600050915081600d0160009054906101000a900460ff1698508850816001016000508960ff1660028110156100025743600019019b50600602019050611b2d8a8d611519565b3461000257610d2c6004808035906020019082018035906020019191908080601f01602080910402602001604051908101604052809392919081815260200183838082843750949650509335935061099092505050565b3461000257610e0c6004808035906020019082018035906020019191908080601f016020809104026020016040519081016040528093929190818152602001838380828437509496505093359350505050602060405190810160405280600081526020015060006000600060005085604051808280519060200190808383829060006004602084601f0104600302600f01f15090500191505090815260200160405180910390206000506001016000508460ff1660028110156100025760060201600050600581018054604080516020808402820181019092528281529394508301828280156108a057602002820191906000526020600020905b8154600160a060020a03168152600190910190602001808311610882575b505093549298604060020a90930463ffffffff1697509195505050505050565b3461000257610d2c6004808035906020019082018035906020019191908080601f01602080910402602001604051908101604052809392919081815260200183838082843750949650505050505050600060006000600060006000602060405190810160405280600081526020015060006000600060006000611c0d8d60006000508f604051808280519060200190808383829060006004602084601f0104600302600f01f1509050019150509081526020016040518091039020600050600d0160009054906101000a900460ff165b600060006000600060006000602060405190810160405280600081526020015060006000600060006000600060006000508f604051808280519060200190808383829060006004602084601f0104600302600f01f15090500191505090815260200160405180910390206000506001016000508e60ff166002811015610002576006020160005090508060020160009054906101000a90046001608060020a03169c508c508060010160109054906101000a90046affffffffffffffffffffff169b508b5080600001600c9054906101000a900463ffffffff169a508a508060000160009054906101000a900460ff16995089508060010160009054906101000a900467ffffffffffffffff16985088508060000160089054906101000a900463ffffffff169750875080600301600050805480602002602001604051908101604052809291908181526020018280548015610b3157602002820191906000526020600020906000905b82829054906101000a900463ffffffff1681526020019060040190602082600301049283019260010382029150808411610afa5790505b505084546001860154949b5060ff6101008204169a5061ffff62010000820416995067ffffffffffffffff604060020a9095049490941697505063ffffffff6401000000009093049290921694508f93505050509295989b509295989b509295989b565b3461000257610c6e6004808035906020019082018035906020019191908080601f016020809104026020016040519081016040528093929190818152602001838380828437505060408051604435808a013560208181028481018201909552818452989a8a359a90996064995093975091909101945092508291908501908490808284375094965050505050505060006000600060006000600060006000600060006000600160009054906101000a9004600160a060020a0316600160a060020a031633600160a060020a0316141515611c3457610002565b005b6040805163ffffffff978816815267ffffffffffffffff9687166020820152948716858201526060850193909352941660808301529290911660a082015290519081900360c00190f35b6040805167ffffffffffffffff9a8b168152988a1660208a015260ff9097168888015263ffffffff958616606089015293881660808801526affffffffffffffffffffff90921660a087015290921660c085015290841660e08401529092166101008201529051908190036101200190f35b604051808d6001608060020a031681526020018c6affffffffffffffffffffff1681526020018b63ffffffff1681526020018a60ff1681526020018967ffffffffffffffff1681526020018863ffffffff168152602001806020018760ff1681526020018661ffff1681526020018567ffffffffffffffff1681526020018463ffffffff1681526020018360ff1681526020018281038252888181518152602001915080519060200190602002808383829060006004602084601f0104600302600f01f1509050019d505050505050505050505050505060405180910390f35b60405180806020018363ffffffff1681526020018281038252848181518152602001915080519060200190602002808383829060006004602084601f0104600302600f01f150905001935050505060405180910390f35b805473ffffffff00000000000000000000000000000000198116608060020a60e060020a606060020a9384900463ffffffff908116820282900492909202929092177bffffffffffffffff0000000000000000000000000000000000000000191660a060020a60c060020a888416430181020402176fffffffff000000000000000000000000191688830292909204929092021782556040518751918716918891908190602080850191908190849082908590600090600490601f850104600302600f01f15090500191505060405180910390207fa2f4a4124ab7224b7753e37c4d34f853613a576f8e812e4f6186a6f1e80d014786604051808260001916815260200191505060405180910390a35b505050505050565b600060005086604051808280519060200190808383829060006004602084601f0104600302600f01f150905001915050908152602001604051809103902060005091508160010160005082600d0160009054906101000a900460ff1660ff16600281101561000257600602018054909150606060020a900463ffffffff9081169086161161100857610002565b600181015442604060020a90910467ffffffffffffffff1611610e6357610f73565b60028054606060020a80840204600160a060020a031990911617905550565b33828263ffffffff1681548110156100025760009182526020909120018054600160a060020a031916606060020a928302929092049190911790555b83546bffffffff00000000000000001916604060020a60e060020a60018401810204021784555b6040805160c0810182528a815260208082018b81528854610100810463ffffffff168486019081526501000000000090910467ffffffffffffffff1660608501908152436080860190815260a086018e815233600160a060020a0316600090815260048d019096529690942094518554935192519151945163ffffffff1990941660e060020a9182028290041767ffffffff00000000191664010000000093820282900493909302929092176bffffffff00000000000000001916604060020a91830292909204021773ffffffffffffffff0000000000000000000000001916606060020a60c060020a93840284900402177bffffffffffffffff0000000000000000000000000000000000000000191660a060020a91830292909204021781559051600190910155845474ffffffffffffffff00000000000000000000000000191685555b5050505050505050505050565b8454606860020a900467ffffffffffffffff16151561121d576111f2565b8454600187019060ff16600281101561000257600602018054865491955062010000900461ffff16890163ffffffff16606860020a90910467ffffffffffffffff164203111561126c576111f2565b8354600185015464010000000090910463ffffffff16604060020a90910467ffffffffffffffff908116919091011642106112a6576111f2565b600160a060020a033316600090815260048501602052604090206001850154815491945067ffffffffffffffff90811660a060020a90920416101561130057835463ffffffff604060020a909104811610611317576111f2565b825463ffffffff908116908a1611611317576111f2565b6001840154835460058601935067ffffffffffffffff91821660a060020a90910490911610156110ac575082548154604060020a90910463ffffffff1690811061104957818054806001018281815481835581811511611398576000838152602090206113989181019083015b808211156113c45760008155600101611384565b5050506000928352506020909120018054600160a060020a031916606060020a33810204179055611085565b5090565b60018054606060020a80840204600160a060020a031990911617905550565b600181015442604060020a90910467ffffffffffffffff161115806114165750600d82015460ff858116911614155b806114695750805463ffffffff848116606060020a90920416148015906114695750805463ffffffff848116608060020a909204161415806114695750805460a060020a900467ffffffffffffffff1643115b806114945750805460ff1643108015906114945750805467ffffffffffffffff861660ff9091164303115b156114d35734158015906114c95750604051600160a060020a033316903480156108fc02916000818181858888f19350505050155b1561155157610002565b600281018054608060020a6001608060020a03821634018102046001608060020a0319909116179055604080516080810182528581526020810185905290810161155687335b6040805167ffffffffffffffff8416408152606060020a600160a060020a038416026020820152905190819003603401902092915050565b610f73565b81524260209182015233600160a060020a0316600090815293815260409384902082518154928401519584015160609094015160ff1990931660f860020a918202919091041764ffffffff00191661010060e060020a9687029690960495909502949094176cffffffffffffffff000000000019166501000000000060c060020a938402849004021774ffffffffffffffff000000000000000000000000001916606860020a9183029290920402179091555050505050565b60006000508f604051808280519060200190808383829060006004602084601f0104600302600f01f150905001915050908152602001604051809103902060005094508460010160005085600d0160009054906101000a900460ff1660010360ff1660028110156100025760060201600050600d860154909450600186019060ff166002811015610002576006020160005060018101549093504267ffffffffffffffff604060020a90920491909116106116c957610002565b83546000604060020a90910463ffffffff1611156116e657610002565b60048b60ff1610156116f757610002565b60018c60ff16101561170857610002565b85511580611717575060408651115b1561172157610002565b5060009050805b85518160ff16101561179c57858160ff168151811015610002579060200190602002015163ffffffff1660001480611792575063ffffffff82161580159061179257508163ffffffff16868260ff168151811015610002579060200190602002015163ffffffff16115b156119e557610002565b825463ffffffff8f8116606060020a909204161461182a578d63ffffffff168f604051808280519060200190808383829060006004602084601f0104600302600f01f15090500191505060405180910390207fa2f4a4124ab7224b7753e37c4d34f853613a576f8e812e4f6186a6f1e80d014789604051808260001916815260200191505060405180910390a35b84600d0160009054906101000a900460ff1660010385600d0160006101000a81548160ff021916908360f860020a908102040217905550438460010160006101000a81548167ffffffffffffffff021916908360c060020a90810204021790555060008460000160106101000a81548163ffffffff021916908360e060020a90810204021790555060008460000160146101000a81548167ffffffffffffffff021916908360c060020a9081020402179055508d84600001600c6101000a81548163ffffffff021916908360e060020a9081020402179055508c8460010160106101000a8154816affffffffffffffffffffff021916908375010000000000000000000000000000000000000000009081020402179055508b8460000160006101000a81548160ff021916908360f860020a9081020402179055508584600301600050908051906020019082805482825590600052602060002090600701600890048101928215611a095791602002820160005b83821115611a2c57835183826101000a81548163ffffffff021916908360e060020a908102040217905550926020019260040160208160030104928301926001030261199e565b858160ff16815181101561000257602090810290910101519150600101611728565b505b50611a5c9291505b808211156113c457805463ffffffff19168155600101611a11565b8015611a075782816101000a81549063ffffffff0219169055600401602081600301049283019260010302611a2c565b50508354600285018054608060020a6001608060020a03821634018102046001608060020a031990911617905560018501805460c060020a42909c018c029b909b04604060020a026fffffffffffffffff000000000000000019909b169a909a1790995550505060e060020a948502949094046401000000000267ffffffff000000001960f060020a97880297909704620100000263ffff00001960f860020a998a02999099046101000261ff00199097169690961797909716949094179490941694909417905550505050505050565b81546001830154600160a060020a038f166000908152600485016020526040902054929d50606060020a90910463ffffffff169950604060020a810467ffffffffffffffff9081169950608060020a82046affffffffffffffffffffff169850908116955060a060020a90910416849010611bca57600160a060020a038c16600090815260048201602052604090205463ffffffff169450611bcf565b600094505b600160a060020a038c1660009081526020839052604090205467ffffffffffffffff6501000000000090910416925050509295985092959850929598565b9b509b509b509b509b509b509b509b509b509b509b509b5091939597999b5091939597999b565b60006000508e604051808280519060200190808383829060006004602084601f0104600302600f01f15090500191505090815260200160405180910390206000506001016000508d60ff166002811015610002576006020180546001820154919c50640100000000900463ffffffff16604060020a90910467ffffffffffffffff1642031215611cc357610002565b60028b015460006001608060020a039091161115611e61578a5460028c015461010090910460ff16906001608060020a03168115610002576002808e01549054604051939092049c506001608060020a039081168d90039b50600160a060020a0390911691908c1680156108fc02916000818181858888f193505050501515611d4b57978901975b60038b0180548d518b9a50919850965060ff9081169087161115611d6e578b5195505b60009450600093505b8560ff168460ff161015611e8457868460ff168154811015610002579060005260206000209060089182820401919006600402905463ffffffff6101009290920a9004169490940193600190930192611d77565b60006000508e604051808280519060200190808383829060006004602084601f0104600302600f01f15090500191505090815260200160405180910390206000506001016000508d60010360ff166002811015610002576006020160005060028082018054608060020a6001608060020a0382168d018102046001608060020a031991821617909155908d018054909116905590505b8a546bffffffff000000000000000019168b555050505050505050505050505050565b600092505b8560ff168360ff161015611dcb578467ffffffffffffffff16878460ff1681548110156100025790600052602060002090600891828204019190066004029054906101000a900463ffffffff1663ffffffff168a026001608060020a03168115610002570491508b8360ff1681518110156100025760209081029091010151604051600160a060020a03909116906001608060020a03841680156108fc02916000818181858888f1935050505015611f415796819003965b600190920191611e8956\",\"nonce\":\"0x0\",\"to\":null,\"transactionIndex\":\"0x0\",\"value\":\"0x0\",\"v\":\"0x2a\",\"r\":\"0x5bf15422eec1ff6c602b1e1f4513aa577d737c105484744ed7722609357ae81d\",\"s\":\"0xcb1249d0abaeb172954896c495dab2f21099fb54a3b1a82adaacc1840bb24b7\"}],\"transactionsRoot\":\"0x42091b3f1a6dc05c829585b7957aec41b4228e993b6a9223ab3f4ba7277fbb5d\",\"uncles\":[]}}";

  @Test
  public void testRawResponseEnabled() {
    configureWeb3Service(true);
    final Web3ClientVersion web3ClientVersion =
        deserialiseWeb3ClientVersionResponse();
    assertThat(web3ClientVersion.getRawResponse(), is(RAW_RESPONSE));
  }

  @Test
  public void testLargeRawResponseEnabled() {
    configureWeb3Service(true);

    buildResponse(LARGE_RAW_RESPONSE);

    EthBlock ethBlock = deserialiseResponse(EthBlock.class);

    assertThat(ethBlock.getRawResponse(), is(LARGE_RAW_RESPONSE));
  }

  @Test
  public void testRawResponseDisabled() {
    configureWeb3Service(false);
    final Web3ClientVersion web3ClientVersion =
        deserialiseWeb3ClientVersionResponse();
    assertThat(web3ClientVersion.getRawResponse(), nullValue());
  }

  private Web3ClientVersion deserialiseWeb3ClientVersionResponse() {
    buildResponse(RAW_RESPONSE);

    return deserialiseResponse(Web3ClientVersion.class);
  }
}
