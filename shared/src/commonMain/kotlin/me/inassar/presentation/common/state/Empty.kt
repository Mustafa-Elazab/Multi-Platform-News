package me.inassar.presentation.common.state

import androidx.compose.foundation.layout.*
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Empty(
    modifier: Modifier = Modifier,
    msg: String,
    onCheckAgain: () -> Unit = {}
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = msg,
            )
            Spacer(modifier = Modifier.size(10.dp))
            OutlinedButton(
                onClick = onCheckAgain
            ) {
                Text(
                    text = "Check Again",
                )
            }
        }
    }
}