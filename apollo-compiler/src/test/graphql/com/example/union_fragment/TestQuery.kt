// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.union_fragment

import com.apollographql.apollo.api.Operation
import com.apollographql.apollo.api.OperationName
import com.apollographql.apollo.api.Query
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.ScalarTypeAdapters
import com.apollographql.apollo.api.ScalarTypeAdapters.Companion.DEFAULT
import com.apollographql.apollo.api.internal.OperationRequestBodyComposer
import com.apollographql.apollo.api.internal.QueryDocumentMinifier
import com.apollographql.apollo.api.internal.ResponseFieldMapper
import com.apollographql.apollo.api.internal.ResponseFieldMarshaller
import com.apollographql.apollo.api.internal.ResponseReader
import com.apollographql.apollo.api.internal.SimpleOperationResponseParser
import com.apollographql.apollo.api.internal.Throws
import com.example.union_fragment.fragment.Character
import com.example.union_fragment.fragment.Starship
import kotlin.Array
import kotlin.Boolean
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import okio.Buffer
import okio.BufferedSource
import okio.ByteString
import okio.IOException

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter")
class TestQuery : Query<TestQuery.Data, TestQuery.Data, Operation.Variables> {
  override fun operationId(): String = OPERATION_ID
  override fun queryDocument(): String = QUERY_DOCUMENT
  override fun wrapData(data: Data?): Data? = data
  override fun variables(): Operation.Variables = Operation.EMPTY_VARIABLES
  override fun name(): OperationName = OPERATION_NAME
  override fun responseFieldMapper(): ResponseFieldMapper<Data> = ResponseFieldMapper.invoke {
    Data(it)
  }

  @Throws(IOException::class)
  override fun parse(source: BufferedSource, scalarTypeAdapters: ScalarTypeAdapters): Response<Data>
      = SimpleOperationResponseParser.parse(source, this, scalarTypeAdapters)

  @Throws(IOException::class)
  override fun parse(byteString: ByteString, scalarTypeAdapters: ScalarTypeAdapters): Response<Data>
      = parse(Buffer().write(byteString), scalarTypeAdapters)

  @Throws(IOException::class)
  override fun parse(source: BufferedSource): Response<Data> = parse(source, DEFAULT)

  @Throws(IOException::class)
  override fun parse(byteString: ByteString): Response<Data> = parse(byteString, DEFAULT)

  override fun composeRequestBody(scalarTypeAdapters: ScalarTypeAdapters): ByteString =
      OperationRequestBodyComposer.compose(
    operation = this,
    autoPersistQueries = false,
    withQueryDocument = true,
    scalarTypeAdapters = scalarTypeAdapters
  )

  override fun composeRequestBody(): ByteString = OperationRequestBodyComposer.compose(
    operation = this,
    autoPersistQueries = false,
    withQueryDocument = true,
    scalarTypeAdapters = DEFAULT
  )

  override fun composeRequestBody(
    autoPersistQueries: Boolean,
    withQueryDocument: Boolean,
    scalarTypeAdapters: ScalarTypeAdapters
  ): ByteString = OperationRequestBodyComposer.compose(
    operation = this,
    autoPersistQueries = autoPersistQueries,
    withQueryDocument = withQueryDocument,
    scalarTypeAdapters = scalarTypeAdapters
  )

  data class Search(
    val __typename: String = "SearchResult",
    val fragments: Fragments
  ) {
    fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
      writer.writeString(RESPONSE_FIELDS[0], this@Search.__typename)
      this@Search.fragments.marshaller().marshal(writer)
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forString("__typename", "__typename", null, false, null),
          ResponseField.forString("__typename", "__typename", null, false, null)
          )

      operator fun invoke(reader: ResponseReader): Search = reader.run {
        val __typename = readString(RESPONSE_FIELDS[0])!!
        val fragments = Fragments(reader)
        Search(
          __typename = __typename,
          fragments = fragments
        )
      }

      @Suppress("FunctionName")
      fun Mapper(): ResponseFieldMapper<Search> = ResponseFieldMapper { invoke(it) }
    }

    data class Fragments(
      val character: Character?,
      val starship: Starship?
    ) {
      fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
        writer.writeFragment(this@Fragments.character?.marshaller())
        writer.writeFragment(this@Fragments.starship?.marshaller())
      }

      companion object {
        private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
            ResponseField.forFragment("__typename", "__typename", listOf(
              ResponseField.Condition.typeCondition(arrayOf("Human", "Droid"))
            )),
            ResponseField.forFragment("__typename", "__typename", listOf(
              ResponseField.Condition.typeCondition(arrayOf("Starship"))
            ))
            )

        operator fun invoke(reader: ResponseReader): Fragments = reader.run {
          val character = readFragment<Character>(RESPONSE_FIELDS[0]) { reader ->
            Character(reader)
          }
          val starship = readFragment<Starship>(RESPONSE_FIELDS[1]) { reader ->
            Starship(reader)
          }
          Fragments(
            character = character,
            starship = starship
          )
        }

        @Suppress("FunctionName")
        fun Mapper(): ResponseFieldMapper<Fragments> = ResponseFieldMapper { invoke(it) }
      }
    }
  }

  /**
   * Data from the response after executing this GraphQL operation
   */
  data class Data(
    val search: List<Search?>?
  ) : Operation.Data {
    override fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
      writer.writeList(RESPONSE_FIELDS[0], this@Data.search) { value, listItemWriter ->
        value?.forEach { value ->
          listItemWriter.writeObject(value?.marshaller())}
      }
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forList("search", "search", mapOf<String, Any>(
            "text" to "test"), true, null)
          )

      operator fun invoke(reader: ResponseReader): Data = reader.run {
        val search = readList<Search>(RESPONSE_FIELDS[0]) { reader ->
          reader.readObject<Search> { reader ->
            Search(reader)
          }
        }
        Data(
          search = search
        )
      }

      @Suppress("FunctionName")
      fun Mapper(): ResponseFieldMapper<Data> = ResponseFieldMapper { invoke(it) }
    }
  }

  companion object {
    const val OPERATION_ID: String =
        "de57eb41c200d48c0f6c508ebf5b4d23b8edd06c6cea371db90ac8160f911b1f"

    val QUERY_DOCUMENT: String = QueryDocumentMinifier.minify(
          """
          |query TestQuery {
          |  search(text: "test") {
          |    __typename
          |    ...Character
          |    ...Starship
          |  }
          |}
          |fragment Character on Character {
          |  __typename
          |  id
          |  name
          |}
          |fragment Starship on Starship {
          |  __typename
          |  name
          |}
          """.trimMargin()
        )

    val OPERATION_NAME: OperationName = object : OperationName {
      override fun name(): String = "TestQuery"
    }
  }
}
