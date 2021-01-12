// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.fragment_used_twice.fragment

import com.apollographql.apollo.api.Fragment
import com.apollographql.apollo.api.Operation
import com.apollographql.apollo.api.internal.ResponseAdapter
import com.example.fragment_used_twice.fragment.adapter.CharacterDetailsImpl_ResponseAdapter
import kotlin.Any
import kotlin.String

class CharacterDetailsImpl : Fragment<CharacterDetailsImpl.Data> {
  override fun adapter(): ResponseAdapter<Data> {
    return CharacterDetailsImpl_ResponseAdapter
  }

  override fun variables(): Operation.Variables = Operation.EMPTY_VARIABLES

  /**
   * A character from the Star Wars universe
   */
  data class Data(
    override val __typename: String = "Character",
    /**
     * The name of the character
     */
    override val name: String,
    /**
     * The date character was born.
     */
    override val birthDate: Any
  ) : CharacterDetails, Fragment.Data
}
