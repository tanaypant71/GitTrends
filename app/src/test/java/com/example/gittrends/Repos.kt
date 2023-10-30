package com.example.gittrends

import org.junit.Test
import org.junit.Assert.*

class ReposTest {

    @Test
    fun `Repos data class correctly initializes`() {
        val repos = Repos(
            totalCount = 42,
            incompleteResults = false,
            items = listOf(
                ItemsItem(
                    name = "SampleRepo",
                    description = "This is a test repository",
                    stargazersCount = 100
                )
            )
        )

        // Check if the properties are correctly initialized
        assertEquals(42, repos.totalCount)
        repos.incompleteResults?.let { assertFalse(it) }
        assertEquals(1, repos.items?.size)
        assertEquals("SampleRepo", repos.items?.first()?.name)
        assertEquals("This is a test repository", repos.items?.first()?.description)
        assertEquals(100, repos.items?.first()?.stargazersCount)
    }
}
