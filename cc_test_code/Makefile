project_dir = construct-destruct
inc_dir = $(project_dir)/inc
src_dir = $(project_dir)/src
objs_dir = objs/construct-destruct

objs = $(objs_dir)/class_define.o\
		$(objs_dir)/main.o


$(objs): $(objs_dir)%.o: $(src_dir)%.cc
	@echo "####################"
	@echo "start compile"
	$(CXX) $(CFLAGS) -I $(inc_dir) -c $< -o $@
	@echo "end compile"
	@echo "####################"
# objs/construct-destruct/class_define.o: $(inc_dir)/class_define.h \
# 	$(src_dir)/class_define.cc
# 	$(CXX) $(CFLAGS) -c $< -o $@

# main: $(objs)
# 	g++ -o main $(objs)

clean:
	rm $(objs)
