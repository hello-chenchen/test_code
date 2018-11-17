objs = point.o

$(objs): %.o: %.c
	@echo "####################"
	@echo "start compile"
	$(CC) -c $(CFLAGS) $< -o $@
	@echo "end compile"
	@echo "####################"

main: $(objs)

clean :
	rm $(objs)