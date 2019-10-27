package io.example.openapi;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

import io.example.openapi.model.Note;
import io.example.openapi.model.Task;

public class TaskNoteAggregationStrategy implements AggregationStrategy {

		@Override
		public Exchange aggregate(Exchange original, Exchange resource) {
            Task task = original.getIn().getBody(Task.class);
            Note note = resource.getIn().getBody(Note.class);
            task.setNote(note);
            original.getOut().setBody(task);
            return original;
    }
		
}